using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ServerGrpc.Models
{
    public class Game
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int GameId { get; set; }

        [ForeignKey("WhitePlayer")]
        public int? WhitePlayerId { get; set; }
        public virtual Player WhitePlayer { get; set; }

        [ForeignKey("BlackPlayer")]
        public int? BlackPlayerId { get; set; }
        public virtual Player BlackPlayer { get; set; }

        [StringLength(5)]
        public string CurrentTurn { get; set; }  // 'white' or 'black'

        [Required]
        [StringLength(10)]
        public string Status { get; set; }  // 'waiting', 'ongoing' or 'finished'

        public bool IsVerified { get; set; }

        [Required]
        public DateTime StartTime { get; set; } = DateTime.Now;
    }
}
