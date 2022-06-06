using System;
using System.Collections.Generic;
using System.Linq;

namespace TestesOO
{
    class Program
    {
        static void Main(string[] args)
        {
            do
            {
                Menu();
                Console.WriteLine("Deseja sair? (S/N): ");
            } while (Console.ReadLine().ToUpper().StartsWith('N'));
        }

        private static void Menu()
        {
            int opcao;

            do
            {
                Console.WriteLine("O que você deseja fazer?");
                Console.WriteLine("1) Cadastrar Conta");
                Console.WriteLine("2) Pagar Conta");
                Console.WriteLine("3) Listar Conta");
                opcao = Convert.ToInt32(Console.ReadLine());
            } while (OpcaoInvalida(opcao));

            if (opcao == 1)
                contas.Add(LerConta());
            else if (opcao == 2)
                PagarConta();
            else if (opcao == 3)
                ListarConta();
        }

        private static void ListarConta()
        {
            Console.WriteLine("Todas as contas:");

            foreach (var conta in contas)
                Console.WriteLine($"{conta.Numero} - {conta.DataVecto:dd/MM/yyyy} - pagamento: {conta.DataPagto:dd/MM/yyyy} - R${conta.Valor:C2}");
            
            Console.WriteLine("----------------------------------");
        }

        private static void PagarConta()
        {
            Console.Write("Informe o número da conta a ser paga: ");
            var numeroConta = Convert.ToInt32(Console.ReadLine());

            var contaSelecionada = contas.Find(x => x.Numero == numeroConta);

            if (contaSelecionada == null)
            {
                Console.WriteLine("Esta conta não existe.");
            }
            else
            {
                Console.WriteLine($"Conta selecionada: {contaSelecionada.Numero}, {contaSelecionada.Valor:C2}");
                Console.Write("Informe o valor a ser pago: ");
                var valorPago = Convert.ToDouble(Console.ReadLine());

                try
                {
                    contaSelecionada.Pagar(valorPago);

                    Console.WriteLine("A conta foi paga com sucesso.");
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Erro ao pagar a conta:");
                    Console.WriteLine(ex.Message);
                }
            }
        }

        private static bool OpcaoInvalida(int opcao)
        {
            return opcao < 1 || opcao > 3;
        }

        private static Conta LerConta()
        {
            var conta = new Conta();

            Console.WriteLine("Inserindo Conta:");
            Console.Write("  Número: ");
            conta.Numero = Convert.ToInt32(Console.ReadLine());
            Console.Write("  Valor: ");
            conta.Valor = Convert.ToDouble(Console.ReadLine());
            Console.Write("  Data de Vencimento: ");
            conta.DataVecto = Convert.ToDateTime(Console.ReadLine());

            return conta;
        }

        private static List<Conta> contas = new List<Conta>();
    }
}
