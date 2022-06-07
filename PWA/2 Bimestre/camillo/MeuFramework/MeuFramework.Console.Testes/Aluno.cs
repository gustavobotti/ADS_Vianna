using MeuFramework.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MeuFramework.Console.Testes
{
    class Aluno : IModelo
    {
        public string Id { get; set; }
        public int Matricula { get; set; }
        public string Nome { get; set; }
    }
}
