using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using TesteEntity.Data;
using TesteEntity.Models;

namespace TesteEntity
{
    class Program
    {
        static void Main(string[] args)
        {
            using(var db = new Contexto())
            {
                //Inserir(db);
                //Alterar(db);
                //Excluir(db);
                Selecionar(db);
            }
        }

        private static void Selecionar(Contexto db)
        {
            var objetos = db.Pessoa.Where(x => x.Nome.Contains("u")).Include(x => x.Contatos);

            foreach (var obj in objetos)
            {
                Console.WriteLine(obj.Nome + ":");
                if (obj.Contatos != null)
                    foreach (var contato in obj.Contatos)
                        Console.WriteLine($"  {contato.Contato}");
            }
        }

        private static void Excluir(Contexto db)
        {
            var p = (from x in db.Pessoa where x.Nome.Equals("Carlos") select x).FirstOrDefault();
            db.Pessoa.Remove(p);
            db.SaveChanges();
        }

        private static void Alterar(Contexto db)
        {
            //var p = db.Pessoa.Where(x => x.Nome.Equals("Bruno")).FirstOrDefault();

            var p = (from x in db.Pessoa where x.Nome.Equals("Bruno") select x).FirstOrDefault();

            p.Nome += " da Silva";

            db.Pessoa.Update(p);
            db.SaveChanges();
        }

        private static void Inserir(Contexto db)
        {
            var p1 = new Pessoa
            {
                Nome = "Ana",
                Contatos = new List<PessoaContato>
                    {
                        new PessoaContato { Contato = "32-99999-8888" },
                        new PessoaContato { Contato = "ana@email.com" }
                    }
            };

            var p2 = new Pessoa
            {
                Nome = "Bruno",
                Contatos = new List<PessoaContato>
                    {
                        new PessoaContato { Contato = "32-99999-7777" },
                        new PessoaContato { Contato = "bruno@email.com" }
                    }
            };

            var p3 = new Pessoa
            {
                Nome = "Carlos",
                Contatos = new List<PessoaContato>
                    {
                        new PessoaContato { Contato = "32-99999-6666" },
                        new PessoaContato { Contato = "carlos@email.com" }
                    }
            };

            db.Pessoa.Add(p1);
            db.Pessoa.Add(p2);
            db.Pessoa.Add(p3);
            db.SaveChanges();
        }
    }
}
