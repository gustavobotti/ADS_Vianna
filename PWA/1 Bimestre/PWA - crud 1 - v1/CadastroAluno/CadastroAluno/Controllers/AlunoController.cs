using CadastroAluno.Models;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CadastroAluno.Controllers
{
    public class AlunoController : Controller
    {
        public IActionResult Index()
        {
            return View(objetos);
        }

        public IActionResult Delete(string id)
        {
            var obj = objetos.FirstOrDefault(x => x.Id.Equals(id));

            return View(obj);
        }

        [HttpPost]
        public IActionResult Delete(Aluno obj)
        {
            var objetoNaLista = objetos.FirstOrDefault(x => x.Id.Equals(obj.Id));

            objetos.Remove(objetoNaLista);

            return View(nameof(Index), objetos);
        }

        public IActionResult Edit(string id)
        {
            var obj = objetos.FirstOrDefault(x => x.Id.Equals(id));

            return View(obj);
        }

        [HttpPost]
        public IActionResult Edit(Aluno obj)
        {
            var objetoNaLista = objetos.FirstOrDefault(x => x.Id.Equals(obj.Id));

            objetoNaLista.Nome = obj.Nome;
            objetoNaLista.Email = obj.Email;
            objetoNaLista.Matricula = obj.Matricula;

            return View(nameof(Index), objetos);
        }

        public IActionResult Details(string id)
        {
            var obj = objetos.FirstOrDefault(x => x.Id.Equals(id));

            return View(obj);
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Aluno obj)
        {
            obj.Id = Guid.NewGuid().ToString();

            objetos.Add(obj);

            return View(nameof(Index), objetos);
        }

        private static IList<Aluno> objetos = new List<Aluno>
        {
            new Aluno { Id = "1", Matricula = 123, Nome = "Ana", Email = "ana@email.com"},
            new Aluno { Id = "2", Matricula = 234, Nome = "Bruno", Email = "bruno@email.com"},
            new Aluno { Id = "3", Matricula = 345, Nome = "Carlos", Email = "carlos@email.com"}
        };
    }
}
