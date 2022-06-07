using System;

namespace Albuns.Terminal
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(nameof(MeuMetodo));
            
            var obj = new Teste();

            Console.WriteLine(nameof(obj.Propriedade1));
            Console.WriteLine(nameof(obj.Propriedade2));
            Console.WriteLine(nameof(obj.MetodoDaClasse));
            Console.WriteLine(nameof(obj));

            Console.WriteLine("Tecle <Enter> para sair...");
            Console.ReadKey();
        }

        static void MeuMetodo()
        {
            Console.WriteLine("Não faço nada...");
        }

        class Teste
        {
            public int Propriedade1 { get; set; }
            public int Propriedade2 { get; set; }

            public void MetodoDaClasse()
            {
                Console.WriteLine("Não faço nada...");
            }
        }
    }
}
