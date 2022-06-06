/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model.dao;

import br.vianna.aula.matadorweb.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author daves
 */
public class UsuarioDao extends DaoBase {

    public static boolean existeLogin(Usuario user) {
        Query q = getCon().createQuery("select count(u) from Usuario u where u.login = :log ");
        
        q.setParameter("log", user.getLogin());
        
         return (long)q.getSingleResult() >= 1; 
        
    }

    public static List<Usuario> buscarTodos() {

        Query q = getCon().createNamedQuery("Usuario.findAll");
        
        return q.getResultList();        
    }

    public static Usuario findById(int id) {
        Query q = getCon().createNamedQuery("Usuario.findByIdusuario");
        
        q.setParameter("idusuario", id);
        
        return (Usuario) q.getSingleResult();  
    }
    
    public Usuario verifiyUser(String login, String senha) throws SQLException{
        
        Query q = getCon().createNamedQuery("Usuario.findByLoginAndSenha");
        
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        
        try {
            
            return (Usuario) q.getSingleResult(); 
        
        } catch (NonUniqueResultException e) {
            throw new SQLException("foi encontrado 2 usuários no banco, contate o administrador");
           //return (Usuario) q.getResultList().get(0);
        } catch (NoResultException e){
            return null;
        }        
        
    }
            
    
}
