/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.dao.impl;

import br.edu.vianna.todo.dao.GenericDao;
import br.edu.vianna.todo.model.Usuario;
import br.edu.vianna.todo.util.CryptoUtil;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO extends GenericDao<Usuario, Integer>{

    @Override
    public void inserir(Usuario obj) throws SQLException {
        em.getTransaction().begin();
        obj.setSenha( CryptoUtil.getHash( obj.getSenha() ) );
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Usuario obj) throws SQLException {       
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit(); 
    }

    @Override
    public void apagar(Usuario obj) throws SQLException {    
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        
    }
    

    @Override
    public Usuario findById(Integer key) throws SQLException {
        String sql = "select * from tb_user where id=10 ";
        String consulta = "select u from Usuario u where u.id = :k ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("k", key);
        try {            
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
  
        //String sql = "select * from tb_user ";
        String consulta = "select u from Usuario u ";
        Query q = em.createQuery(consulta);
        
        return q.getResultList();     
    
    }
    
    
    public Usuario findByCpfAndSenha(String cpf, String senha) throws SQLException {
        
        String consulta = "select u from Usuario u "
                + "where upper(u.cpf) = upper(:cpff) "
                + "and u.senha = :sen ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("cpff", cpf);
        q.setParameter("sen", CryptoUtil.getHash(senha) );
        try {            
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch(NonUniqueResultException e){
            return (Usuario) q.getResultList().get(0);
        }      
        
        
    }
    
    public Usuario findByCpf(int cpf) throws SQLException {
        
        String consulta = "select u from Usuario u "
                + "where u.cpf = :cpff ";
        Query q = em.createQuery(consulta);
        
        q.setParameter("cpff", cpf);
        try {            
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch(NonUniqueResultException e){
            return (Usuario) q.getResultList().get(0);
        }
    }
    
}
