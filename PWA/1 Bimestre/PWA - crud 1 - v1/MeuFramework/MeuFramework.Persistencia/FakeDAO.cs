using MeuFramework.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace MeuFramework.Persistencia
{
    public class FakeDAO<T> where T : IModelo
    {
        public void Inserir(T obj) => registros.Add(obj);
        public void Excluir(string id)
        {
            var obj = RetornarPorId(id);

            if (obj == null)
                throw new Exception($"O registro com id '{id}' não foi encontrado.");

            registros.Remove(obj);
        }

        public void Alterar(T obj)
        {
            Excluir(obj.Id);
            Inserir(obj);
        }

        public T Encontrar(Func<T, bool> selecionar)
        {
            foreach (var obj in registros)
            {
                if (selecionar(obj))
                    return obj;
            }

            return default(T);
        }

        public T RetornarPorId(string id)
        {
            return registros.Where(x => x.Id.Equals(id)).FirstOrDefault();
        }

        public IList<T> RetornarTodos() => registros;

        private readonly List<T> registros = new List<T>();
    }

}
