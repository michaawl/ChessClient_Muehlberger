using Microsoft.EntityFrameworkCore;
using ServerGrpc.Models;


namespace ServerGrpc.Data
{
    public class ChessDbContext : DbContext
    {
        public DbSet<Player> Players { get; set; }
        public DbSet<Game> Games { get; set; }
        public DbSet<Move> Moves { get; set; }

        public ChessDbContext(DbContextOptions<ChessDbContext> options) : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
        }
    }
}
