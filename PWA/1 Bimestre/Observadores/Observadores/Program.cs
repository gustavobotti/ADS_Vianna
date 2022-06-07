using System;

namespace Observadores
{
    class Program
    {
        static void Main(string[] args)
        {
            var cruds = new ICrud[] { new PedidoView() };
            int opcao;

            do
            {
                opcao = EscolhaCrud(cruds);

                if (opcao < 1 || opcao > cruds.Length)
                {
                    Console.WriteLine("Opção inválida!");
                }
                else
                {
                    var crud = cruds[opcao - 1];

                    EscolhaAcao(crud);
                }

            } while (opcao != cruds.Length + 1);

        }

        private static void EscolhaAcao(ICrud crud)
        {
            Console.WriteLine($"{crud.Nome}:");

            
            Console.WriteLine("1) Consultar: ");
            Console.WriteLine("2) Inserir: ");
            Console.WriteLine("3) Alterar: ");
            Console.WriteLine("4) Excluir: ");
            Console.WriteLine("5) Listar: ");
            Console.WriteLine("Escolha uma ação: ");

            switch(Convert.ToInt32(Console.ReadLine()))
            {
                case 1:
                    crud.Consultar();
                    break;
                case 2:
                    crud.Inserir();
                    break;
                case 3:
                    crud.Alterar();
                    break;
                case 4:
                    crud.Excluir();
                    break;
                case 5:
                    crud.Listar();
                    break;
                default:
                    Console.WriteLine("A ação escolhida é inválida!");
                    break;
            }
        }

        private static int EscolhaCrud(ICrud[] cruds)
        {
            int opcao;
            Console.WriteLine("Menu: ");

            for (int i = 0; i < cruds.Length; i++)
            {
                Console.WriteLine($" {i + 1}) {cruds[i].Nome}");
            }

            Console.WriteLine($" {cruds.Length + 1}) Sair");

            Console.Write("Informe a sua opção: ");
            opcao = Convert.ToInt32(Console.ReadLine());
            return opcao;
        }
    }
}
