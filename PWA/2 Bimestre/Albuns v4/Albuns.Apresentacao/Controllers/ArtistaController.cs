using Albuns.Dominio.Models;
using Albuns.Infra.DAOs;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Albuns.Apresentacao.Controllers
{
    public class ArtistaController : Controller
    {
        public IActionResult Index()
        {
            return View(dao.RetornarTodos());
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Artista obj)
        {
            obj.Id = Guid.NewGuid().ToString();
            dao.Inserir(obj);
            return RedirectToAction(nameof(Index), dao.RetornarTodos());
        }

        public IActionResult Edit(string id)
        {
            var obj = dao.RetornarPorId(id);

            return View(obj);
        }

        [HttpPost]
        public IActionResult Edit(Artista obj)
        {
            dao.Alterar(obj);
            return RedirectToAction(nameof(Index), dao.RetornarTodos());
        }

        public IActionResult Details(string id)
        {
            var obj = dao.RetornarPorId(id);

            return View(obj);
        }

        public IActionResult Delete(string id)
        {
            var obj = dao.RetornarPorId(id);

            return View(obj);
        }

        [HttpPost]
        public IActionResult DeleteConfirm(string id)
        {
            dao.Excluir(id);
            return RedirectToAction(nameof(Index), dao.RetornarTodos());
        }

        private ArtistaDAO dao = new ArtistaDAO();
    }
}
