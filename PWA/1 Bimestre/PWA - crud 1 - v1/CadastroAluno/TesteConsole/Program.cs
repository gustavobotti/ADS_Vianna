using System;
using System.ComponentModel;
using System.Linq.Expressions;

namespace TesteConsole
{
    class Program
    {
        class Aluno
        {
            [DisplayName("Matrícula do Aluno")]
            public int Matricula { get; set; }
            public string Nome { get; set; }
        }

        static void Main(string[] args)
        {
            var obj = new Aluno();

            Testar(obj, x => obj.Nome);

            Console.ReadKey();
        }

        private static void Testar<T>(Aluno obj, Expression<Func<object, T>> expression)
        {
            var memberExp = expression.Body as MemberExpression;

            var nomeProp = memberExp.Member.Name;

            var tipo = obj.GetType();

            var propriedade = tipo.GetProperty(nomeProp);

            var nomeApresentado = false;

            foreach (var atrib in propriedade.GetCustomAttributes(true))
            {
                if (atrib.GetType() == typeof(DisplayNameAttribute))
                {
                    var displayName = ((DisplayNameAttribute)atrib).DisplayName;
                    nomeApresentado = true;
                    Console.WriteLine(displayName);
                }
            }

            if (!nomeApresentado)
                Console.WriteLine(nomeProp);
        }
    }
}
