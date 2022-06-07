using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Entidades.Interfaces;
using ControleProdutos.Infra.DAOs;
using ControleProdutos.Infra.Data;
using ControleProdutos.Visao.Views;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace ControleProdutos.Visao.ViewModels
{
    public class ProdutoViewModel : CrudViewModel<Produto, WProduto>
    {
        public ProdutoViewModel() : this(new ProdutoDAO(new Contexto())) { }

        public ProdutoViewModel(IProdutoDAO dao)
        {
            this.dao = dao;
            Lista = new ObservableCollection<Produto>();
            Filtrar();
        }

        public ProdutoInsumoViewModel InsumoViewModel => insumoViewModel;

        protected override void Filtrar()
        {
            Lista.Clear();
            var objetos = dao.Filtrar(x => x.Descricao.Contains(""));
            foreach (var obj in objetos)
                Lista.Add(obj);
        }

        protected override void InserirObjeto(Produto obj)
        {
            dao.Inserir(obj);
        }

        protected override void AlterarObjeto(Produto obj)
        {
            dao.Alterar(obj);
        }

        protected override void ExcluirObjeto(Produto obj)
        {
            dao.Excluir(obj.Id);
        }

        protected override void DescartarAlteracao(Produto obj)
        {
            dao.DescartarAlteracao(obj);
        }

        protected override void RealizarCargaTardia(Produto obj)
        {
            dao.RealizarCargaTardia(obj);
        }

        protected override void ObjetoSelecionadoAlterado()
        {
            insumoViewModel = new ProdutoInsumoViewModel(ObjetoSelecionado);
        }

        private readonly IProdutoDAO dao;
        private ProdutoInsumoViewModel insumoViewModel = null;
    }
}
