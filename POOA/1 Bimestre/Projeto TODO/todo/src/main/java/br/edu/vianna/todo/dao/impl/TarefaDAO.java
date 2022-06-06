/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.dao.impl;

import br.edu.vianna.todo.dao.GenericDao;
import br.edu.vianna.todo.model.Tarefa;
import br.edu.vianna.todo.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class TarefaDAO extends GenericDao<Tarefa, Integer>{

    @Override
    public void inserir(Tarefa obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Tarefa obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void apagar(Tarefa obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Tarefa findById(Integer key) throws SQLException {
        return em.find(Tarefa.class, key);
    }

    @Override
    public List<Tarefa> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String consulta = "select t from Tarefa t";
//        Query q = em.createQuery(consulta);
//        
//        return q.getResultList();
    } 
    
    
    public List<Tarefa> findTarefasByUsuarioAndCategoria(
            Integer usuario, String categoria) throws SQLException {
        
        String sql = " select * from Tarefa t "
                + "inner join Categoria c on t.idCategoria = c.id "
                + "where idusario = 1 "
                + "and c.nome = 'xpto' ";
        
        String consulta = "select t from Tarefa t"
                + " Where t.usuario.id = :id and"
                + " t.categoria.nome like :cate ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("id", usuario);
        q.setParameter("cate", "%"+categoria+"%");
        
        return q.getResultList();
        
    }

    public List<Tarefa> findMinhasTarefas(int id) {
        String consulta = "select t from Tarefa t"
                + " Where t.usuario.id = :id ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("id", id);
        
        return q.getResultList();
    }
    
}
