using System;
using System.Runtime.CompilerServices;

namespace Testes
{
    class Program
    {
        static void Main(string[] args)
        {
            Metodo1();
            MetodoX();

            Console.ReadKey();
        }

        static void Metodo1() => Imprime();
        static void MetodoX() => Imprime();

        static void Imprime([CallerMemberName]string nomeMetodo = "") => Console.WriteLine(nomeMetodo);
    }
}
