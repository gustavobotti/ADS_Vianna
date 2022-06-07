using Albuns.Dominio.Models;
using Dapper;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Albuns.Infra.DAOs
{
    public abstract class BaseDAO<T> where T: Modelo
    {
        public void Inserir(T obj)
        {
            var sql = $"insert into {NomeTabela} ({GetNomesCamposParaInsert()}) values ({GetNomesParametrosParaInsert()})";

            ExecutarComando(sql, obj);
        }

        public void Alterar(T obj)
        {
            var sql = $"update {NomeTabela} set {GetNomesCamposParaUpdate()} where id=@Id";

            ExecutarComando(sql, obj);
        }

        public void Excluir(T obj)
        {
            var sql = $"delete from {NomeTabela} where id=@Id";

            ExecutarComando(sql, obj);
        }

        public void Excluir(string id)
        {
            var sql = $"delete from {NomeTabela} where id=@Id";

            ExecutarComando(sql, new { Id = id });
        }

        public IEnumerable<T> RetornarTodos()
        {
            var sql = $"select * from {NomeTabela}";

            return ExecutarConsulta(sql, null);
        }

        public T RetornarPorId()
        {
            var sql = $"select * from {NomeTabela} where id=@Id";

            return ExecutarConsultaQueRetornaObjetoUnico(sql, null);
        }

        protected abstract string NomeTabela { get; }

        protected abstract string[] NomeCamposExcetoId { get; }

        protected IEnumerable<T> ExecutarConsulta(string sql, object parametros)
        {
            using (var conexao = new MySqlConnection(GetStringConexao()))
            {
                conexao.Open();

                var lista = conexao.Query<T>(sql, parametros).ToList();

                conexao.Close();

                return lista;
            }
        }

        protected T ExecutarConsultaQueRetornaObjetoUnico(string sql, object parametros)
        {
            using (var conexao = new MySqlConnection(GetStringConexao()))
            {
                conexao.Open();

                var obj = conexao.QueryFirst<T>(sql, parametros);

                conexao.Close();

                return obj;
            }
        }

        protected void ExecutarComando(string sql, object obj)
        {
            using (var conexao = new MySqlConnection(GetStringConexao()))
            {
                conexao.Open();

                conexao.Execute(sql, obj);

                conexao.Close();
            }
        }

        private string GetNomesCamposParaUpdate()
        {
            var sb = new StringBuilder();

            sb.Append(NomeCamposExcetoId[0].ToLower() + "=@" + NomeCamposExcetoId[0]);

            for (int i = 1; i < NomeCamposExcetoId.Length; i++)
                sb.Append("," + NomeCamposExcetoId[i].ToLower() + "=@" + NomeCamposExcetoId[i]);

            return sb.ToString();
        }

        private string GetNomesCamposParaInsert()
        {
            var sb = new StringBuilder();

            sb.Append("id");

            for (int i = 0; i < NomeCamposExcetoId.Length; i++)
                sb.Append("," + NomeCamposExcetoId[i].ToLower());
            
            return sb.ToString();
        }

        private string GetNomesParametrosParaInsert()
        {
            var sb = new StringBuilder();

            sb.Append("@id");

            for (int i = 0; i < NomeCamposExcetoId.Length; i++)
                sb.Append(",@" + NomeCamposExcetoId[i]);

            return sb.ToString();
        }

        private string GetStringConexao() => "";
    }
}
