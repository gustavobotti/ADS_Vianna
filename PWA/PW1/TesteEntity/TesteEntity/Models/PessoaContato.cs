using System;
using System.Collections.Generic;
using System.Text;

namespace TesteEntity.Models
{
    public class PessoaContato : Entidade
    {
        public Guid PessoaId { get; set; }
        public string Contato { get; set; }
    }
}
