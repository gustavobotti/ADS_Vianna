/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.dao.impl;

import br.edu.vianna.todo.dao.GenericDao;
import br.edu.vianna.todo.model.Exame;
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
public class ExameDAO extends GenericDao<Exame, Integer>{

    @Override
    public void inserir(Exame obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Exame obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void apagar(Exame obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Exame findById(Integer key) throws SQLException {
        return em.find(Exame.class, key);
    }

    @Override
    public List<Exame> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String consulta = "select t from Exame t";
//        Query q = em.createQuery(consulta);
//        
//        return q.getResultList();
    } 
    
    
    public List<Exame> findExamesByUsuarioAndCategoria(
            Integer usuario, String categoria) throws SQLException {
        
        String sql = " select * from Exame t "
                + "inner join Categoria c on t.idCategoria = c.id "
                + "where idusario = 1 "
                + "and c.nome = 'xpto' ";
        
        String consulta = "select t from Exame t"
                + " Where t.usuario.id = :id and"
                + " t.categoria.nome like :cate ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("id", usuario);
        q.setParameter("cate", "%"+categoria+"%");
        
        return q.getResultList();
        
    }

    public List<Exame> findMeusExames(int id) {
        String consulta = "select t from Exame t"
                + " Where t.usuario.id = :id ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("id", id);
        
        return q.getResultList();
    }
    
}
