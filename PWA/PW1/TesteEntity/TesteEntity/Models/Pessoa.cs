using System;
using System.Collections.Generic;
using System.Text;

namespace TesteEntity.Models
{
    public class Pessoa: Entidade
    {
        public string Nome { get; set; }
        public IList<PessoaContato> Contatos { get; set; }
    }
}
