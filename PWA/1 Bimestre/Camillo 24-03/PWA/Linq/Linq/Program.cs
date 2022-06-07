using System;
using System.Linq;

namespace Linq
{
    class Program
    {
        static void Main(string[] args)
        {
            var idades = new int[] { 20, 21, 22, 25, 30, 40, 55 };

            /*
            var idadesLista = idades.Filtrar(x => x <= 21);

            foreach (var item in idadesLista)
                Console.WriteLine(item);
            */

            //Func<int, bool> funcao = EhAbaixo30;

            //var qtdeAbaixo30 = idades.Count(x => x < 30);
            //var somaPares = idades.Sum(x => x % 2 == 0 ? x : 0);
            //var qtdeAbaixo30 = idades.Count(funcao);
            //Console.WriteLine(qtdeAbaixo30);

            
            var idadesMaioresQue30 = idades.Where(x => x > 30);

            foreach (var item in idadesMaioresQue30)
                Console.WriteLine(item);
            

            /*
            var dobroDeCadaIdadeMaiorQue30 =
                idades.Where(x => x > 30).Select(x => x * 2);

            foreach (var item in dobroDeCadaIdadeMaiorQue30)
                Console.WriteLine(item);
            */

            /*
            var idadesAbaixo30 = from x in idades where x < 30 select x;

            foreach (var item in idadesAbaixo30)
                Console.WriteLine(item);
            */

            Console.ReadKey();
        }

        static bool EhAbaixo30(int x) => x < 30;
    }
}
