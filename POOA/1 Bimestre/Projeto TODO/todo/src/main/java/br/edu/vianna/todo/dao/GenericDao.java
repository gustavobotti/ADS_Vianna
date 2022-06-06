/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public abstract class GenericDao<C, K> {
   
    private EntityManagerFactory emf;            
    protected EntityManager em;
    
    public GenericDao(){
        emf = Persistence.createEntityManagerFactory("pooa_PU");
        em = emf.createEntityManager();
    }
    public EntityManager getEm() {
        return em;
    } 
    public abstract void inserir(C obj) throws SQLException;
    public abstract void alterar(C obj) throws SQLException;
    public abstract void apagar(C obj) throws SQLException;
    
    public abstract C findById(K key) throws SQLException;
    public abstract List<C> findAll() throws SQLException;
       
}
