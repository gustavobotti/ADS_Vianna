using ControleProdutos.Entidades.Entidades;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Interfaces
{
    public interface IValidacaoCrud<T> where T : Entidade
    {
        IValidacaoResultado PodeInserir(T obj);
        IValidacaoResultado PodeAlterar(T obj);
        IValidacaoResultado PodeExcluir(Guid id);
    }
}
