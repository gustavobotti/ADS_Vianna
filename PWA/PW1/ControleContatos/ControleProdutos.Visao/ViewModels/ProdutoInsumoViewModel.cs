using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Visao.Views;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Visao.ViewModels
{
    public class ProdutoInsumoViewModel : CrudViewModel<ProdutoInsumo, WProdutoInsumo>
    {
        public ProdutoInsumoViewModel(Produto produto) => this.produto = produto;

        protected override void AlterarObjeto(ProdutoInsumo obj)
        {
            
        }

        protected override void DescartarAlteracao(ProdutoInsumo obj)
        {
            
        }

        protected override void ExcluirObjeto(ProdutoInsumo obj)
        {
            produto.ExcluirInsumo(obj);
        }

        protected override void Filtrar()
        {
            
        }

        protected override void InserirObjeto(ProdutoInsumo obj)
        {
            obj.ProdutoId = produto.Id;
            
            produto.AdicionarInsumo(obj);
        }

        protected override void RealizarCargaTardia(ProdutoInsumo obj)
        {
            
        }

        private Produto produto;
    }
}
