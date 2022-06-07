using Microsoft.AspNetCore.Mvc;
using PrimeiroProjetoMvc.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PrimeiroProjetoMvc.Controllers
{
    public class TesteController : Controller
    {
        public IActionResult Index()
        {
            ViewData["mensagem"] = "Estou testando isso...";
            var obj = new Teste
            {
                Id = "1",
                Propriedade1 = "Este é o conteúdo da propriedade 1",
                Propriedade2 = 100
            };

            return View(obj);
        }
    }
}
