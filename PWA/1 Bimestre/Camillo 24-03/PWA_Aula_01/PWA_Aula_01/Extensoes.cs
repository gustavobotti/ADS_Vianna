using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PWA_Aula_01
{
    public static class Extensoes
    {
        public static string EntreAspas(this string texto)
        {
            return "\"" + texto + "\"";
        }

        public static string Entre(this string texto, string inicioEFim)
        {
            return inicioEFim + texto + inicioEFim;
        }
    }
}
