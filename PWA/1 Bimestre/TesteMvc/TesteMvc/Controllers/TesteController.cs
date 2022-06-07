using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteMvc.Models;

namespace TesteMvc.Controllers
{
    public class TesteController : Controller
    {
        public IActionResult Index()
        {
            ViewData["mensagem"] = "Estou testando isso...";
            var obj = new Teste
            {
                Id = "1",
                Propriedade1 = "este é o conteúdo da propriedade 1",
                Propriedade2 = 100
            };

            return View(obj);
        }
    }
}
