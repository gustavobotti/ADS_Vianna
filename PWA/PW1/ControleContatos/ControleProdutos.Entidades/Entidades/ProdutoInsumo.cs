using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Entidades
{
    public class ProdutoInsumo : Entidade
    {
        public Guid ProdutoId { get; set; }
        public string Insumo { get; set; }

        public double Qtd { get; set; }


    }
}
