using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ServerGrpc.Models
{
    public class Move
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int MoveId { get; set; }

        [ForeignKey("Game")]
        public int GameId { get; set; }
        public virtual Game Game { get; set; }

        [ForeignKey("Player")]
        public int PlayerId { get; set; }
        public virtual Player Player { get; set; }

        [Required]
        [StringLength(10)]
        public string PieceType { get; set; }

        [Required]
        [StringLength(3)]
        public string Origin { get; set; }

        [Required]
        [StringLength(3)]
        public string Destination { get; set; }

        [Required]
        public DateTime MoveTime { get; set; } = DateTime.Now;
    }
}
