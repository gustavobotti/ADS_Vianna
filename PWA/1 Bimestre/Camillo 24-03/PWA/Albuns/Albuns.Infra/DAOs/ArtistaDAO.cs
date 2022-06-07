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
        protected override string NomeTabela => "artista";
        protected override string[] NomeCamposExcetoId
        {
            get
            {
                if (campos == null)
                {
                    var obj = new Artista();

                    campos = new string[] {
                        nameof(obj.Nome),
                        nameof(obj.Email)
                    };
                }

                return campos;
            }
        }

        private string[] campos = null;
    }
}
