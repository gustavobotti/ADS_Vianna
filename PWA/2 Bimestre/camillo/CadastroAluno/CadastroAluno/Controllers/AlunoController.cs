using CadastroAluno.Models;
using MeuFramework.Persistencia;
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
            return View(GetDAO().RetornarTodos());
        }

        public IActionResult Delete(string id)
        {
            var obj = GetDAO().RetornarPorId(id);

            return View(obj);
        }

        [AcceptVerbs("GET", "POST")]
        public IActionResult ValidarEmail(string email) 
        {
            if (email.Length < 6) 
            {
                return Json("Isso não é um email, meu camarada!");
            }
            return Json(true);
        }

        [HttpPost]
        public IActionResult Delete(Aluno obj)
        {
            var dao = GetDAO();
            
            dao.Excluir(obj.Id);

            TempData["AlunoMensagem"] = $"Aluno '{obj.Nome}' excluído com sucesso!";

            return RedirectToAction(nameof(Index));
        }

        public IActionResult Edit(string id)
        {
            var obj = GetDAO().RetornarPorId(id);

            return View(obj);
        }

        [HttpPost]
        public IActionResult Edit(Aluno obj)
        {
            var dao = GetDAO();
            
            dao.Alterar(obj);

            TempData["AlunoMensagem"] = $"Aluno '{obj.Nome}' alterado com sucesso!";

            return View(nameof(Index), dao.RetornarTodos());
        }

        public IActionResult Details(string id)
        {
            var obj = GetDAO().RetornarPorId(id);

            return View(obj);
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Aluno obj)
        {
            if (!ModelState.IsValid)
            {
                TempData["AlunoErro"] = "Aluno inválido";
                //throw new Exception("Aluno inválido");
                return View(obj);
            }
            else
            {

                obj.Id = Guid.NewGuid().ToString();

                var dao = GetDAO();

                dao.Inserir(obj);

                TempData["AlunoMensagem"] = $"Aluno '{obj.Nome}' inserido com sucesso!";

                return RedirectToAction(nameof(Index));
            }
        }

        private FakeDAO<Aluno> GetDAO() => new FakeDAO<Aluno>();
    }
}
