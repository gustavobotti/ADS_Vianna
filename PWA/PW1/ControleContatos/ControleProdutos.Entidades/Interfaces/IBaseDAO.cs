using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;

namespace ControleProdutos.Entidades.Interfaces
{
    public interface IBaseDAO<T>
    {
        void Inserir(T obj);
        void Excluir(Guid id);
        void Alterar(T obj);
        T RetornarPorId(Guid id);
        void RealizarCargaTardia(T obj);
        IEnumerable<T> Filtrar(Expression<Func<T, bool>> expressao);
        bool ObjetoExiste(Guid id);
        void DescartarAlteracao(T obj);
    }
}
