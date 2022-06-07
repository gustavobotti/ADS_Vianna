using MeuFramework.Entidades;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace MeuFramework.Persistencia
{
    public class FakeDAO<T> where T : IModelo
    {
        static FakeDAO()
        {
            string caminho = GetCaminho();

            if (File.Exists(caminho))
                registros = JsonConvert.DeserializeObject<List<T>>(File.ReadAllText(caminho));
            else
                registros = new List<T>();
        }

        public void Inserir(T obj)
        {
            registros.Add(obj);

            Gravar();
        }

        public void Excluir(string id)
        {
            var obj = RetornarPorId(id);

            if (obj == null)
                throw new Exception($"O registro com id '{id}' não foi encontrado.");

            registros.Remove(obj);

            Gravar();
        }

        public void Alterar(T obj)
        {
            Excluir(obj.Id);
            Inserir(obj);

            Gravar();
        }

        public T Encontrar(Func<T, bool> selecionar)
        {
            foreach (var obj in registros)
            {
                if (selecionar(obj))
                    return obj;
            }

            return default(T);
        }

        public T RetornarPorId(string id)
        {
            return registros.Where(x => x.Id.Equals(id)).FirstOrDefault();
        }

        public IList<T> RetornarTodos() => registros;

        private static void Gravar()
        {
            var caminho = GetCaminho();

            var conteudo = JsonConvert.SerializeObject(registros);

            File.WriteAllText(caminho, conteudo, Encoding.UTF8);
        }

        private static string GetCaminho()
        {
            var tipo = typeof(T);

            var nome = tipo.FullName;

            var caminho = Environment.CurrentDirectory + $@"\{nome}-dados.json";

            return caminho;
        }

        private readonly static List<T> registros;
    }

}
