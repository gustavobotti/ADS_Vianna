using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace CadastroAluno.Models
{
    public class Aluno
    {
        public string Id { get; set; }

        [DisplayName("Matrícula")]
        public int Matricula { get; set; }

        public string Nome { get; set; }
        
        [DisplayName("E-mail")]        
        public string Email { get; set; }
    }
}
