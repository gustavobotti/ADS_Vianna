using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Interfaces
{
    public interface IValidacaoResultado
    {
        bool Ok { get; }
        IList<IValidacaoErro> Erros { get; }
    }
}
