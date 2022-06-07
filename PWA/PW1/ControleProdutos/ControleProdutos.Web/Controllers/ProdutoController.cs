using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Infra.DAOs;
using ControleProdutos.Infra.Data;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ControleProdutos.Web.Controllers
{
    //[Authorize]
    [Route("api/[controller]")]
    [ApiController]
    public class ProdutoController : ControllerBase
    {
        // GET: api/<ProdutoController>
        [HttpGet]
        public ActionResult<IEnumerable<Produto>> Get()
        {
            return Ok(dao.Filtrar(x => x.Descricao.Contains("")));
        }

        // GET api/<ProdutoController>/5
        [HttpGet("{id}")]
        public ActionResult<Produto> Get(Guid id)
        {
            var obj = dao.RetornarPorId(id);

            if (obj == null)
                return NotFound();

            dao.RealizarCargaTardia(obj);

            return Ok(obj);
        }

        // POST api/<ProdutoController>
        [HttpPost]
        public ActionResult<Produto> Post([FromBody] Produto obj)
        {
            if (obj == null)
                return BadRequest();

            obj.Id = Guid.NewGuid();

            try
            {
                dao.Inserir(obj);

                return CreatedAtAction($"{nameof(Get)}", obj);
            }
            catch
            {
                throw;
            }
        }

        // PUT api/<ProdutoController>/5
        [HttpPut("{id}")]
        public ActionResult Put(Guid id, [FromBody] Produto obj)
        {
            if (obj == null || !obj.Id.Equals(id))
                return BadRequest();

            try
            {
                dao.Alterar(obj);

                return NoContent();
            }
            catch
            {
                throw;
            }
        }

        // DELETE api/<ProdutoController>/5
        [HttpDelete("{id}")]
        public ActionResult Delete(Guid id)
        {
            try
            {
                dao.Excluir(id);

                return NoContent();
            }
            catch
            {
                var obj = dao.RetornarPorId(id);

                if (obj == null)
                    return NotFound();

                throw;
            }
        }

        private ProdutoDAO dao = new ProdutoDAO(new Contexto());
    }
}
