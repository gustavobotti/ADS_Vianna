using ControleProdutos.Entidades.Entidades;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Interfaces
{
    public interface IValidacaoObjeto<T> where T: Entidade
    {
        string NomeEntidade { get; }
        void ValidarAlteracao(T obj, IValidacaoResultado resultado);
        void ValidarInclusao(T obj, IValidacaoResultado resultado);
        void ValidarExclusao(Guid id, IValidacaoResultado resultado);
    }
}
