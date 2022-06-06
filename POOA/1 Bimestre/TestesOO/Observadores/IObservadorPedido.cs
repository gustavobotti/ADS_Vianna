using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observadores
{
    interface IObservadorPedido
    {
        void TotalAlterado(double total);
    }
}
