using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Interfaces
{
    public interface IValidacaoErro
    {
        string Propriedade { get; set; }
        string Mensagem { get; set; }
    }
}
