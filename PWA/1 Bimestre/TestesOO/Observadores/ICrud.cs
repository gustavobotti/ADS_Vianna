using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    interface ICrud
    {
        string Nome { get; }
        void Inserir();
        void Alterar();
        void Consultar();
        void Excluir();
        void Listar();
    }
}
