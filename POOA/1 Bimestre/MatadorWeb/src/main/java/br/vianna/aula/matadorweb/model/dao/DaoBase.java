/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daves
 */
public class DaoBase  {
    
    private static EntityManagerFactory emf; // = Persistence.createEntityManagerFactory("matadorPU");
        
    private static EntityManager con; // = emf.createEntityManager();
    
    public static void close(){
        if (con.isOpen()){
            con.close();
        }
    }
    
    public static EntityManager getCon(){
        if (con == null || !con.isOpen()){
           emf = Persistence.createEntityManagerFactory("matadorPU");
           con = emf.createEntityManager();
        }
        return con;
    }
        
}
