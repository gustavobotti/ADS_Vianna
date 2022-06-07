using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    class PedidoItem
    {
        public Produto Produto { get; set; }
        public double Quantidade { get; set; }
        public double Total => Produto == null ? 0 : Quantidade * Produto.Preco;
    }
}
