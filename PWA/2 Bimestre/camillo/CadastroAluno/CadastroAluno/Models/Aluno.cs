using MeuFramework.Entidades;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace CadastroAluno.Models
{
    public class Aluno : IModelo
    {
        public string Id { get; set; }

        [Range(1000, 9999, ErrorMessage = "Inválido!")]
        [DisplayName("Matrícula")]
        public int Matricula { get; set; }

        [StringLength(20, MinimumLength = 3, ErrorMessage = "O {0} deve ter mais de {2} letras e no máximo {1}")]
        public string? Nome { get; set; }
        
        [Remote(action:"ValidarEmail", controller:"Aluno")]
        [DisplayName("E-mail")]      
        //[EmailAddress(ErrorMessage = "Email inválido!")]
        [Required(ErrorMessage = "É necessário informar o {0}")]
        public string Email { get; set; }
    }
}
