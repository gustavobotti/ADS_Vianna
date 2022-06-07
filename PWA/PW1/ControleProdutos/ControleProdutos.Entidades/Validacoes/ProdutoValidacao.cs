using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Entidades.Interfaces;
using ControleProdutos.Entidades.Validacoes.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ControleProdutos.Entidades.Validacoes
{
    public class ProdutoValidacao : IValidacaoObjeto<Produto>
    {
        public ProdutoValidacao(IProdutoDAO dao) => this.dao = dao;

        public string NomeEntidade => "Produto";

        public void ValidarAlteracao(Produto obj, IValidacaoResultado resultado)
        {
            Validar(obj, resultado);
        }

        public void ValidarInclusao(Produto obj, IValidacaoResultado resultado)
        {
            Validar(obj, resultado);
        }

        public void ValidarExclusao(Guid id, IValidacaoResultado resultado)
        {
            
        }

        private void Validar(Produto obj, IValidacaoResultado resultado)
        {
            if (obj.Descricao == null || obj.Descricao.Length < 3)
                resultado.Erros.Add(new ValidacaoErro(nameof(obj.Descricao), "O descricao precisa ter ao menos 3 caracteres."));
        }

        private readonly IProdutoDAO dao;
    }
}
