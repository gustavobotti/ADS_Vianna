using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Albuns.Dominio.Models
{
    public class Album : Modelo
    {
        public Artista Artista { get; set; }

        public IEnumerable<Musica> Musicas { get; set; }

        public int QtdeMusicas
        {
            get
            {
                if (Musicas == null)
                    return 0;

                return Musicas.Count();
            }
        }

        public int DuracaoTotalEmSegundos
        {
            get
            {
                if (Musicas == null)
                    return 0;

                return Musicas.Select(x => x.DuracaoEmSegundos).Sum();
            }
        }
    }
}
