using System;
using MeuFramework.Persistencia;
using System.Collections.Generic;

namespace MeuFramework.Console.Testes
{
    class Program
    {
        static void Main(string[] args)
        {
            var dao = new FakeDAO<Aluno>();

            dao.Inserir(new Aluno { Id = "1", Matricula = 123, Nome = "Ana" });
            dao.Inserir(new Aluno { Id = "2", Matricula = 125, Nome = "Bruno" });
            dao.Inserir(new Aluno { Id = "3", Matricula = 127, Nome = "Carlos" });

            ImprimirAlunos(dao.RetornarTodos());

            
        }

        private static void ImprimirAlunos(IList<Aluno> alunos)
        {
            foreach (var item in alunos)
            {
                System.Console.WriteLine(item.Nome);
            }
        }
    }
}
