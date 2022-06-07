using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    class Pedido : Modelo
    {
        public Pedido(IObservadorPedido observador) => this.observador = observador;

        public int Numero { get; set; }

        public DateTime Data { get; set; }

        public PedidoItem[] Itens { get => itens.ToArray(); }

        public void AdicionarItem(Produto produto, double quantidade)
        {
            var item = new PedidoItem
            {
                Produto = produto,
                Quantidade = quantidade
            };

            itens.Add(item);

            observador.TotalAlterado(Total);
        }

        public double Total => Itens.Sum(x => x.Total);

        private List<PedidoItem> itens = new List<PedidoItem>();
        private IObservadorPedido observador;
    }
}
