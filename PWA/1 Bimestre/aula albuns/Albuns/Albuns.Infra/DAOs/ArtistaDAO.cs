using Albuns.Dominio.Models;
using MySql.Data.MySqlClient;
using Dapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Albuns.Infra.DAOs
{
    public class ArtistaDAO : BaseDAO<Artista>
    {
        public void Alterar(Artista obj)
        {
            var sql = $"update {NomeTabela} set nome=@Nome where id=@Id";

            ExecutarComando(sql, obj);
        }

        public IEnumerable<Artista> RetornarTodos()
        {
            var sql = $"select * from {NomeTabela} order by nome";

            return ExecutarConsulta(sql, null);
        }

        protected override string NomeTabela => "artista";

        protected override string[] NomeCamposExcetoId
        {
            get
            {
                if (campos == null)
                {
                    var obj = new Artista();

                    campos = new string[] {
                        nameof(obj.Nome)
                    };
                }

                return campos;
            }
        }

        private string[] campos = null;
    }
}
