using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestesOO
{
    public class Conta
    {
        public int Numero { get => numero; set => numero = value; }
        public DateTime DataVecto { get => dataVecto; set => dataVecto = value; }
        public DateTime DataPagto { get => dataPagto; set => dataPagto = value; }
        public double Valor { get => valor; set => valor = value; }
        public double ValorPago { get => valorPago; set => valorPago = value; }

        public void Pagar(double valorPago)
        {
            if (valorPago < valor)
                throw new Exception("Valor insuficiente para pagamento.");

            this.valorPago = valorPago;
            dataPagto = DateTime.Now;
        }

        private int numero;
        private DateTime dataVecto;
        private DateTime dataPagto;
        private double valor;
        private double valorPago;
    }
}
