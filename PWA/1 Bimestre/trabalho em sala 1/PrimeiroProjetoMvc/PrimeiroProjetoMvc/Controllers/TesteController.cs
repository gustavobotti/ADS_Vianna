using Microsoft.AspNetCore.Mvc;
using PrimeiroProjetoMvc.DAO;
using PrimeiroProjetoMvc.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PrimeiroProjetoMvc.Controllers
{
    public class TesteController : Controller
    {
        TesteDAO td = new TesteDAO();
        public IActionResult Index()
        {
            //ViewData["mensagem"] = "Estou testando isso...";

            var lista = td.RetornarTodos();
        //    {
        //        new Teste
        //        {
        //            Id = "1",
        //            Propriedade1 = "Este é o conteúdo da propriedade 1",
        //            Propriedade2 = 100
        //        },

        //        new Teste
        //        {
        //            Id = "2",
        //            Propriedade1 = "Este é o conteúdo da propriedade 2",
        //            Propriedade2 = 200
        //        },

        //        new Teste
        //        {
        //            Id = "3",
        //            Propriedade1 = "Este é o conteúdo da propriedade 3",
        //            Propriedade2 = 300
        //        },

        //};
            //var obj = new Teste
            //{
            //    Id = "1",
            //    Propriedade1 = "Este é o conteúdo da propriedade 1",
            //    Propriedade2 = 100
            //};

            return View(lista);
        }
    }
}
