/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.dao.impl;

import br.edu.vianna.todo.dao.GenericDao;
import br.edu.vianna.todo.model.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class CategoriaDAO extends GenericDao<Categoria, Integer>{

    @Override
    public void inserir(Categoria obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Categoria obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void apagar(Categoria obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Categoria findById(Integer key) throws SQLException {
        return em.find(Categoria.class, key);
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
    
        String consulta = "select c from Categoria c";
        Query q = em.createQuery(consulta);
        
        return q.getResultList();
    
    }    
}
