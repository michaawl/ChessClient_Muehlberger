using ChessGrpc;
using Grpc.Core;
using Microsoft.EntityFrameworkCore;
using ServerGrpc.Data;
using ServerGrpc.Models;

namespace ServerGrpc.Services
{
    public class ChessMatchmakingService : ChessMatchmaking.ChessMatchmakingBase
    {
        private readonly ChessDbContext _dbContext;

        public ChessMatchmakingService(ChessDbContext dbContext) {

            _dbContext = dbContext;
        
        }

        //with context we can manage our call, like cancel it
        public override async Task<StartGameResponse> StartGame(StartGameRequest request, ServerCallContext context)
        {
            if (string.IsNullOrWhiteSpace(request.PlayerName))
            {
                throw new RpcException(new Status(StatusCode.InvalidArgument, "You must enter a name"));
            }

            var existingGame = await _dbContext.Games
                .FirstOrDefaultAsync(g => g.BlackPlayer == null && g.Status == "waiting");

            Player player = new Player
            {
                PlayerName = request.PlayerName
            };

            string assignedColor;
            Game game;

            if (existingGame != null)
            {
                existingGame.BlackPlayer = player;
                existingGame.Status = "ongoing";
                existingGame.CurrentTurn = "white";
                assignedColor = "black";
                _dbContext.Games.Update(existingGame);
                game = existingGame;
            }
            else
            {
                game = new Game
                {
                    WhitePlayer = player,
                    Status = "waiting",
                    CurrentTurn = "white",
                    StartTime = DateTime.Now,
                    IsVerified = true
                };
                assignedColor = "white";
                await _dbContext.Games.AddAsync(game);
            }

            await _dbContext.SaveChangesAsync();

            return new StartGameResponse
            {
                GameId = game.GameId.ToString(),
                PlayerColor = assignedColor
            };
        }
    }
}
