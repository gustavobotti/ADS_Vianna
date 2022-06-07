using ControleProdutos.Entidades.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Validacoes.Comum
{
    public class ValidacaoErro : IValidacaoErro
    {
        public ValidacaoErro(string propriedade, string mensagem)
        {
            Propriedade = propriedade;
            Mensagem = mensagem;
        }

        public ValidacaoErro(string mensagem)
        {
            Propriedade = "";
            Mensagem = mensagem;
        }

        public string Propriedade { get; set; }
        public string Mensagem { get; set; }
    }
}
