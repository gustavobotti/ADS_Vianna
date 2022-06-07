using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    class PedidoView : ICrud, IObservadorPedido
    {
        public PedidoView(FakeDAO<Pedido> daoPedido, FakeDAO<Produto> daoProduto)
        {
            this.daoPedido = daoPedido;
            this.daoProduto = daoProduto;
        }

        public string Nome => "Pedido";

        public void Alterar()
        {
            throw new NotImplementedException();
        }

        public void Consultar()
        {
            throw new NotImplementedException();
        }

        public void Excluir()
        {
            throw new NotImplementedException();
        }

        public void Inserir()
        {
            var ped = new Pedido(this);
            Console.WriteLine("Inserindo um pedido:");

            Console.Write("   Número: ");
            ped.Numero = Convert.ToInt32(Console.ReadLine());

            Console.Write("   Data: ");
            ped.Data = Convert.ToDateTime(Console.ReadLine());

            //var prod = new Produto
            //{
            //    Codigo = 1,
            //    Descricao = "Produto 1",
            //    Preco = 11.11
            //};

            //ped.AdicionarItem(prod, 5);
            //ped.AdicionarItem(prod, 1);

            daoPedido.Inserir(ped);
        }

        public void Listar()
        {
            var objetos = daoPedido.RetornarTodos();

            foreach (var ped in objetos)
            {
                //Console.WriteLine($"{ped.Numero}...");
            }
        }

        public void TotalAlterado(double total)
        {
            Console.WriteLine($"Novo total: {total:C2}");
        }

        private FakeDAO<Pedido> daoPedido;
        private FakeDAO<Produto> daoProduto;
    }
}
