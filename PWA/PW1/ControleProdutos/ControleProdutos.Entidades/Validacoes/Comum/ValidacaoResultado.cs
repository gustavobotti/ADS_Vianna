using ControleProdutos.Entidades.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Validacoes.Comum
{
    public class ValidacaoResultado : IValidacaoResultado
    {
        public bool Ok => erros.Count == 0;
        public IList<IValidacaoErro> Erros => erros;

        private IList<IValidacaoErro> erros = new List<IValidacaoErro>();
    }
}
