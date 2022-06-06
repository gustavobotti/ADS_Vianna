using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    class ProdutoView : ICrud
    {
        public ProdutoView(FakeDAO<Produto> daoProduto)
        {
            this.daoProduto = daoProduto;
        }
        public string Nome => "Produto";

        public void Alterar()
        {
            Console.WriteLine("Alterando um produto:");

            Console.Write("   Código: ");
            var cod = Convert.ToInt32(Console.ReadLine());

            var produtoSelecionado = daoProduto.Encontrar(x => x.Codigo == cod);
            if (produtoSelecionado == null) {
                Console.WriteLine("Produto não encontrado;");
            } else { 

            Console.Write("   Descrição: ");
            produtoSelecionado.Descricao = Convert.ToString(Console.ReadLine());

            Console.Write("   Preço: ");
            produtoSelecionado.Preco = Convert.ToDouble(Console.ReadLine());

            daoProduto.Alterar(produtoSelecionado);

            Console.WriteLine(" Produto alterado. ");

            }
        }

        public void Consultar()
        {
            Console.WriteLine("Consultando um produto:");

            Console.Write("   Código: ");
            var cod = Convert.ToInt32(Console.ReadLine());

            var produtoSelecionado = daoProduto.Encontrar(x => x.Codigo == cod);
            if (produtoSelecionado == null)
            {
                Console.WriteLine("Codigo não encontrado;");
            }
            else
            {
                Console.WriteLine(" ");

                Console.Write($"   ID: {produtoSelecionado.Id}");

                Console.Write($"   Código: {produtoSelecionado.Codigo}");

                Console.Write($"   Descrição: {produtoSelecionado.Descricao}");

                Console.Write($"   Preço: {produtoSelecionado.Preco}");

                Console.WriteLine(" ");

            }
        }

        public void Excluir()
        {
            Console.WriteLine("Excluindo um produto:");

            Console.Write("   Código: ");
            var cod = Convert.ToInt32(Console.ReadLine());

            var produtoSelecionado = daoProduto.Encontrar(x => x.Codigo == cod);
            if (produtoSelecionado == null)
            {
                Console.WriteLine("Codigo não encontrado;");
            }
            else
            {
                daoProduto.Excluir(produtoSelecionado.Id);

                Console.WriteLine("Produto excluído.");
            }
        }

        public void Inserir()
        {
            var prod = new Produto();
            Console.WriteLine("Inserindo um produto:");

            Console.Write("   Código: ");
            prod.Codigo = Convert.ToInt32(Console.ReadLine());

            Console.Write("   Descrição: ");
            prod.Descricao = Convert.ToString(Console.ReadLine());

            Console.Write("   Preço: ");
            prod.Preco = Convert.ToDouble(Console.ReadLine());

            prod.Id =  Convert.ToString(prod.Codigo);

            daoProduto.Inserir(prod);

            //Guid id = Guid.NewGuid();

            Console.WriteLine("Produto inserido.");

        }

        public void Listar()
        {
            var registros = daoProduto.RetornarTodos();
            foreach (var obj in registros)
            {
                Console.Write($"Código: { obj.Codigo } ");
                Console.Write($"Descrição: { obj.Descricao } ");
                Console.Write($"Preço: { obj.Preco } ");
                Console.WriteLine(" ");
            }
        }

        public void TotalAlterado(double total)
        {
            Console.WriteLine($"Novo total: {total:C2}");
        }

        private FakeDAO<Produto> daoProduto;
    }
}
