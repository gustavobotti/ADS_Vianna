using Dapper;
using MySql.Data.MySqlClient;
using PrimeiroProjetoMvc.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PrimeiroProjetoMvc.DAO
{
    public class TesteDAO
    {
        public List<Teste> RetornarTodos()
        {
            var stringConexao = "SERVER=localhost; DATABASE=teste; UID=root; PASSWORD=aluno;";
            var lista = new List<Teste>();

            using (var conexao = new MySqlConnection(stringConexao))
            {
                conexao.Open();

                SelecionarComDapper(conexao);

                lista = SelecionarComDapper(conexao);

                conexao.Close();
            }

            static void SelecionarComDapper(MySqlConnection conexao)
            {
                var sql = "select * from teste order by id";

                var lista = conexao.Query<Teste>(sql);
            }

            return lista;
        }         
    }
}
