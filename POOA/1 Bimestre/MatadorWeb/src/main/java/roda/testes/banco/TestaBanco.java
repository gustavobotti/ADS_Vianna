/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roda.testes.banco;

import br.vianna.aula.matadorweb.model.Jogador;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author daves
 */
public class TestaBanco {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("matadorPU");
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Conectou ");
        
        //criaRegistros(em);
        
        Query q = em.createNamedQuery("Usuario.findAll");
        
        List<Usuario> lista = (List<Usuario>) q.getResultList();
        for (Usuario usuario : lista) {
            System.out.println("1 --> "+usuario.getNome());
        }
        
//        
//        Query q1 = em.createQuery("SELECT u FROM Usuario u where "
//                + " u.timeList.size = 1 order by u.nome ");
//        
//        long total = (long) q1.getSingleResult();
//        System.out.println(" total de times  "+total);
        
//        List<Time> lista1 = (List<Time>) q1.getResultList();
//        for (Time t : lista1) {
//            System.out.println("2 --> "+t.getNome());
//        }
                                
        
        
    }

    private static void criaRegistros(EntityManager em) {
        Usuario u = new Usuario(0, "Pedrin", "pedrin", "123");
        Usuario u1 = new Usuario(0, "Gustin", "gugu", "123");
        Usuario u2 = new Usuario(0, "Karlin", "kaka", "123");
        Usuario u3 = new Usuario(0, "Markin", "mama", "123");
        Time t1 = new Time(0, "São Paulo", Date.from(LocalDate.of(1950, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t2 = new Time(0, "Vasco", Date.from(LocalDate.of(1960, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t3 = new Time(0, "Botafogo", Date.from(LocalDate.of(1910, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t4 = new Time(0, "Fluminense", Date.from(LocalDate.of(1900, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t5 = new Time(0, "Pameiras", Date.from(LocalDate.of(1980, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t6 = new Time(0, "Cruzeiro", Date.from(LocalDate.of(1900, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t7 = new Time(0, "Flamengo", Date.from(LocalDate.of(1885, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t8 = new Time(0, "Sport", Date.from(LocalDate.of(1893, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        Time t9 = new Time(0, "Fortaleza", Date.from(LocalDate.of(1900, Month.JANUARY, 5).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() ));
        
        Random r = new Random();
        
        Jogador j1 = new Jogador(0, "Quem", r.nextInt(20));
        Jogador j2 = new Jogador(0, "Qual", r.nextInt(20));
        Jogador j3 = new Jogador(0, "Onde", r.nextInt(20));
        Jogador j4 = new Jogador(0, "Porque", r.nextInt(20));
        Jogador j5 = new Jogador(0, "Será", r.nextInt(20));
        Jogador j6 = new Jogador(0, "Artilheiro", r.nextInt(20));
        Jogador j7 = new Jogador(0, "Beque", r.nextInt(20));
        Jogador j8 = new Jogador(0, "Betin", r.nextInt(20));
        Jogador j9 = new Jogador(0, "Virgulino", r.nextInt(20));
        Jogador j10 = new Jogador(0, "Joazin", r.nextInt(20));
        Jogador j11 = new Jogador(0, "Zizi", r.nextInt(20));
        Jogador j12 = new Jogador(0, "benin", r.nextInt(20));
        Jogador j13 = new Jogador(0, "Azulzin", r.nextInt(20));
        Jogador j14 = new Jogador(0, "zizi", r.nextInt(20));
        Jogador j15 = new Jogador(0, "vava", r.nextInt(20));
        
        em.getTransaction().begin();
        
        em.persist(u);
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        
        t1.setUsuario(u);
        em.persist(t1);
        t2.setUsuario(u);
        em.persist(t2);
        t3.setUsuario(u);
        em.persist(t3);
        t4.setUsuario(u1);
        em.persist(t4);
        t5.setUsuario(u1);
        em.persist(t5);
        t6.setUsuario(u2);
        em.persist(t6);
        t7.setUsuario(u3);
        em.persist(t7);
        t8.setUsuario(u3);
        em.persist(t8);
        t9.setUsuario(u3);
        em.persist(t9);
        
        j1.setTime(t1);
        em.persist(j1);
        j2.setTime(t1);
        em.persist(j2);
        j3.setTime(t2);
        em.persist(j3);
        j4.setTime(t2);
        em.persist(j4);
        j5.setTime(t3);
        em.persist(j5);
        j6.setTime(t3);
        em.persist(j6);
        j7.setTime(t4);
        em.persist(j7);
        j8.setTime(t4);
        em.persist(j8);
        j9.setTime(t5);
        em.persist(j9);
        j10.setTime(t6);
        em.persist(j10);
        j11.setTime(t6);
        em.persist(j11);
        j12.setTime(t7);
        em.persist(j12);
        j13.setTime(t8);
        em.persist(j13);
        j14.setTime(t8);
        em.persist(j14);
        j15.setTime(t9);
        em.persist(j15);
        
        em.getTransaction().commit();
    }
    
}
