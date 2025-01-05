using ChessGrpc;
using Grpc.Core;
using Microsoft.EntityFrameworkCore;
using ServerGrpc.Data;
using ServerGrpc.Models;

namespace ServerGrpc.Services
{
    public class ChessGameService : ChessGame.ChessGameBase
    {
        private readonly ChessDbContext _dbContext;

        public ChessGameService(ChessDbContext dbContext) {
            _dbContext = dbContext;
        }

        //Returns Current Update of the game (last move verified/game status ..)
        public override async Task<GameStatusResponse> GetGameUpdate(GameStatusRequest request, ServerCallContext context)
        {
            var gameId = int.Parse(request.GameId);

            var game = await _dbContext.Games
                .Include(g => g.WhitePlayer)
                .Include(g => g.BlackPlayer)
                .FirstOrDefaultAsync(g => g.GameId == gameId);

            if (game == null)
            {
                return new GameStatusResponse
                {
                    GameId = request.GameId,
                    Status = "Game not found"
                };
            }

            var lastMove = _dbContext.Moves?
                .Where(m => m.GameId == gameId)
                .OrderByDescending(m => m.MoveTime)
                .FirstOrDefault();

            return new GameStatusResponse
            {
                GameId = request.GameId,
                Status = game.Status ?? string.Empty,
                CurrentTurn = game.CurrentTurn ?? string.Empty,
                WhitePlayer = game.WhitePlayer?.PlayerName ?? string.Empty,
                BlackPlayer = game.BlackPlayer?.PlayerName ?? "Waiting for second player",
                LastMoveId = lastMove?.MoveId.ToString() ?? "",
                LastMoveOrigin = lastMove?.Origin?.ToString() ?? string.Empty,
                LastMoveDesination = lastMove?.Destination?.ToString() ?? string.Empty,
                IsVerified = game.IsVerified
            };
        }

        //called when move was made
        public override async Task<MakeMoveResponse> MakeMove(MakeMoveRequest request, ServerCallContext context)
        {
            var gameId = int.Parse(request.GameId);

            var game = await _dbContext.Games
                .Include(g => g.WhitePlayer)
                .Include(g => g.BlackPlayer)
                .FirstOrDefaultAsync(g => g.GameId == gameId);

            if (game == null)
            {
                return new MakeMoveResponse
                {
                    Success = false,
                    Message = "Game not found"
                };
            }

            var player = await _dbContext.Players
                .FirstOrDefaultAsync(p => p.PlayerName == request.PlayerName);

            if (player == null)
            {
                return new MakeMoveResponse
                {
                    Success = false,
                    Message = "Player not found"
                };
            }

            var move = new Move
            {
                GameId = game.GameId,
                PlayerId = player.PlayerId,
                PieceType = request.Piece,
                Origin = request.MoveOrigin,
                Destination = request.MoveDestination,
                MoveTime = DateTime.Now
            };

            _dbContext.Moves.Add(move);
            await _dbContext.SaveChangesAsync();

            game.IsVerified = false;
            await _dbContext.SaveChangesAsync();

            return new MakeMoveResponse
            {
                Success = true,
                Message = "Move processed successfully"
            };
        }

        //called when player veries a move
        public override async Task<VerifyMoveResponse> VerifyMove(VerifyMoveRequest request, ServerCallContext context)
        {
            var gameId = int.Parse(request.GameId);

            var game = await _dbContext.Games
                .FirstOrDefaultAsync(g => g.GameId == gameId);

            if (game == null)
            {
                return new VerifyMoveResponse
                {
                    Success = false
                };
            }

            if (request.OpponentAnswer)
            {

                game.IsVerified = true;
                game.CurrentTurn = game.CurrentTurn == "white" ? "black" : "white";
            }
            else
            {

                game.IsVerified = true;
                var lastMove = await _dbContext.Moves
                    .Where(m => m.GameId == gameId)
                    .OrderByDescending(m => m.MoveTime)
                    .FirstOrDefaultAsync();

                if (lastMove != null)
                {
                    _dbContext.Moves.Remove(lastMove);
                }
            }

            await _dbContext.SaveChangesAsync();

            return new VerifyMoveResponse
            {
                Success = true
            };
        }

        //called when player wants details about a single move
        public override async Task<GetMoveResponse> GetMove(GetMoveRequest request, ServerCallContext context)
        {
            var moveId = int.Parse(request.MoveId);

            var move = await _dbContext.Moves
                .Include(m => m.Game)
                .Include(m => m.Player)
                .FirstOrDefaultAsync(m => m.MoveId == moveId);

            if (move == null)
            {
                return new GetMoveResponse
                {
                    Success = false,
                    GameId = "",
                    PlayerName = "",
                    Piece = "",
                    MoveOrigin = "",
                    MoveDestination = "",
                    MoveTime = "",
                };
            }

            return new GetMoveResponse
            {
                Success = true,
                GameId = move.GameId.ToString(),
                PlayerName = move.Player.PlayerName,
                Piece = move.PieceType,
                MoveOrigin = move.Origin,
                MoveDestination = move.Destination,
                MoveTime = move.MoveTime.ToString(), 
            };
        }

        //called when game ended -> king was captured
        public override async Task<EndGameResponse> EndGame(EndGameRequest request, ServerCallContext context)
        {
            var gameId = int.Parse(request.GameId);

            var game = await _dbContext.Games
                .FirstOrDefaultAsync(g => g.GameId == gameId);

            if (game == null)
            {
                return new EndGameResponse
                {
                    Success = false
                };
            }

            game.Status = "finished";


            await _dbContext.SaveChangesAsync();

            return new EndGameResponse
            {
                Success = true
            };
        }

        //returns all moves in descending order by movetime
        public override async Task<GetAllMovesResponse> GetAllMoves(GetAllMovesRequest request, ServerCallContext context)
        {
            var gameId = int.Parse(request.GameId);

            var moves = await _dbContext.Moves
                .Where(m => m.GameId == gameId)
                .OrderByDescending(m => m.MoveTime)
                .Select(m => new SingleMove
                {

                    Piece = m.PieceType,
                    MoveOrigin = m.Origin,
                    MoveDestination = m.Destination
                })
                .ToListAsync();

            var response = new GetAllMovesResponse();
            response.Moves.AddRange(moves);

            return response;
        }
    }

}
