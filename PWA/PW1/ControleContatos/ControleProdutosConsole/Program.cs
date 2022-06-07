using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Entidades.Validacoes;
using ControleProdutos.Infra.DAOs;
using ControleProdutos.Infra.Data;
using System;
using System.Collections.Generic;
using System.Linq;

namespace ControleProdutosConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            var contexto = new Contexto();
            var dao = new ProdutoDAO(contexto);
            var validacao = new ProdutoValidacaoService(dao);

            //var p1 = new Produto
            //{
            //    Descricao = "Ana",
            //    Insumos = new List<ProdutoInsumo>
            //        {
            //            new ProdutoInsumo { Insumo = "32-99999-8888" },
            //            new ProdutoInsumo { Insumo = "ana@email.com" }
            //        }
            //};

            //var p2 = new Produto
            //{
            //    Descricao = "Bruno",
            //    Insumos = new List<ProdutoInsumo>
            //        {
            //            new ProdutoInsumo { Insumo = "32-99999-7777" },
            //            new ProdutoInsumo { Insumo = "bruno@email.com" }
            //        }
            //};

            //var p3 = new Produto
            //{
            //    Descricao = "Carlos",
            //    Insumos = new List<ProdutoInsumo>
            //        {
            //            new ProdutoInsumo { Insumo = "32-99999-6666" },
            //            new ProdutoInsumo { Insumo = "carlos@email.com" }
            //        }
            //};

            var p1 = dao.Filtrar(x => x.Descricao.Equals("Ana")).FirstOrDefault();

            //Inserir(p1, validacao, dao);
            //Inserir(p2, validacao, dao);
            //Inserir(p3, validacao, dao);

            //p1.Descricao += " (Alterado)";
            //Alterar(p1, validacao, dao);

            var produtos = dao.Filtrar(x => x.Descricao.Contains("a"));

            foreach (var p in produtos)
            {
                dao.RealizarCargaTardia(p);
            }

            Imprimir(produtos);

            Console.WriteLine();

            Excluir(p1.Id, validacao, dao);

            produtos = dao.Filtrar(x => x.Descricao.Length > 1);

            foreach (var p in produtos)
            {
                dao.RealizarCargaTardia(p);
            }

            Imprimir(produtos);
        }

        private static void Imprimir(IEnumerable<Produto> produtos)
        {
            Console.WriteLine("Produtos:");

            foreach (var item in produtos)
            {
                Console.WriteLine(item.Descricao);

                foreach (var insumo in item.Insumos)
                {
                    Console.WriteLine(insumo.Insumo);
                }
            }
        }

        private static void Excluir(Guid id, ProdutoValidacaoService validacao, ProdutoDAO dao)
        {
            var result = validacao.Get().PodeExcluir(id);

            if (result.Erros.Count == 0)
                dao.Excluir(id);
        }

        private static void Alterar(Produto p, ProdutoValidacaoService validacao, ProdutoDAO dao)
        {
            var result = validacao.Get().PodeInserir(p);

            if (result.Erros.Count == 0)
                dao.Alterar(p);
        }

        private static void Inserir(Produto p, ProdutoValidacaoService validacao, ProdutoDAO dao)
        {
            var result = validacao.Get().PodeInserir(p);

            if (result.Erros.Count == 0)
                dao.Inserir(p);
            //else
            //    foreach (var item in result.Erros)
            //    {
            //        Console.WriteLine(item.Mensagem);
            //    }
        }
    }
}
