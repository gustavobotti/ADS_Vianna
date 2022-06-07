using System;
using System.Linq;
using System.Threading.Tasks;

namespace ProgAssincrona1
{
    class Program
    {
        private const int MAX = 1000000000;
        private const int NUMERO_THREADS = 10;

        static void Main(string[] args)
        {
            Console.WriteLine($"Número: {ProcessamentoSincrono()}");

            Console.WriteLine($"Número: {ProcessamentoAssincrono()}");

            Console.WriteLine($"Número: {ProcessamentoAssincronoUsandoTask()}");

            Console.WriteLine($"Número: {ProcessamentoAssincronoUsandoPLinq()}");

            Console.ReadKey();
        }

        private static int ProcessamentoSincrono()
        {
            DateTime inicio = DateTime.Now;

            int cont = Processamento(0, MAX);

            Console.WriteLine($"Síncrono: {(DateTime.Now - inicio).TotalSeconds} segundos.");

            return cont;
        }

        private static int ProcessamentoAssincrono()
        {
            int div = MAX / NUMERO_THREADS;
            DateTime inicio = DateTime.Now;

            int[] cont = new int[NUMERO_THREADS];
            int tot;

            Parallel.For(0, NUMERO_THREADS, i => cont[i] = Processamento(i * div, (i + 1) * div));
            tot = cont.Sum();

            Console.WriteLine($"Assíncrono: {(DateTime.Now - inicio).TotalSeconds} segundos.");

            return tot;
        }

        private static object ProcessamentoAssincronoUsandoTask()
        {
            var div = MAX / NUMERO_THREADS;
            var inicio = DateTime.Now;

            var cont = new Task<int>[NUMERO_THREADS];

            int tot;

            for (int i = 0; i < NUMERO_THREADS; i++)
            {
                cont[i] = ProcessamentoAsync(i * div, (i + 1) * div);
            }

            Task.WaitAll(cont);

            tot = cont.Sum(x => x.Result);

            Console.WriteLine($"Assíncrono com Task: {(DateTime.Now - inicio).TotalSeconds} segundos.");

            return tot;
        }

        private static int ProcessamentoAssincronoUsandoPLinq()
        {
            var inicio = DateTime.Now;
            var div = MAX / NUMERO_THREADS;

            int tot = Enumerable.Range(0, NUMERO_THREADS).AsParallel().Sum((index) => Processamento(index * div, (index + 1) * div));

            Console.WriteLine($"Assíncrono com PLinq: {(DateTime.Now - inicio).TotalSeconds} segundos.");

            return tot;
        }

        //private static bool ProcessamentoIndividual(int num)
        //{
        //    double raiz = Math.Sqrt(num);

        //    return (raiz == Math.Floor(raiz));
        //}

        private static int Processamento(int inicio, int fim)
        {
            int cont = 0;
            double raiz;

            for (int i = inicio; i < fim; i++)
            {
                raiz = Math.Sqrt(i);
                if (raiz == Math.Floor(raiz))
                    cont++;
            }

            return cont;
        }

        private async static Task<int> ProcessamentoAsync(int inicio, int fim)
        {
            int cont = 0;
            double raiz;

            await Task.Run(() =>
            {
                for (int i = inicio; i < fim; i++)
                {
                    raiz = Math.Sqrt(i);
                    if (raiz == Math.Floor(raiz))
                        cont++;
                }
            });

            return cont;
        }
    }

}
