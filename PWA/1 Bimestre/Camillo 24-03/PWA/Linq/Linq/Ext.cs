using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Linq
{
    public static class Ext
    {
        public static IEnumerable<T> Filtrar<T>(this IEnumerable<T> itens, Func<T, bool> filtro)
        {
            var lista = new List<T>();

            foreach (var item in itens)
                if (filtro(item))
                    lista.Add(item);

            return lista;
        }
    }
}
