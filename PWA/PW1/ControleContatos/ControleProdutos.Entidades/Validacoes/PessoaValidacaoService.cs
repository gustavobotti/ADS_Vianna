using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Entidades.Interfaces;
using ControleProdutos.Entidades.Validacoes.Comum;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Entidades.Validacoes
{
    public class ProdutoValidacaoService
    {
        public ProdutoValidacaoService(IProdutoDAO dao)
        {
            validacaoEspecifica = new ProdutoValidacao(dao);
            validacao = new CrudValidacaoService<Produto, IProdutoDAO>(dao, validacaoEspecifica);
        }

        public CrudValidacaoService<Produto, IProdutoDAO> Get()
        {
            return validacao;
        }

        private readonly CrudValidacaoService<Produto, IProdutoDAO> validacao;
        private readonly ProdutoValidacao validacaoEspecifica;
    }
}
