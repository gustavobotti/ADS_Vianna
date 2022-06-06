/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model.dao;

import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author daves
 */
public class TimeDao extends DaoBase {

    public static List<Time> buscarTimesUsuario(Usuario user) {
        Query q = getCon().createQuery("select t from Time t Where t.usuario.idusuario = :user  ");

        q.setParameter("user", user.getIdusuario());

        return q.getResultList();
    }

    public static List<Time> buscarTimesFiltro(String nome, Usuario u, String dt1, String dt2) {

//        String sql = "select t from Time t Where t.nome like :nome ";
//        if ( u.getIdusuario() != -1){
//            sql += " and t.usuario.idusuario = :user ";
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Query q = getCon().createQuery("select t from Time t Where t.nome like :nome and "
                + " (t.usuario.idusuario = :user or -1 = :user ) and "
                + " (t.dataFundacao >= :dt1 and t.dataFundacao <= :dt2 )");

        q.setParameter("nome", "%" + nome + "%");

        q.setParameter("user", u.getIdusuario());

        try {
            q.setParameter("dt1", sdf.parse(dt1));
        } catch (ParseException ex) {
            try {
                q.setParameter("dt1", sdf.parse("1500-01-01"));
            } catch (ParseException ex1) {
            }
        }

        try {
            //q.setParameter("dt1", dt1);
            q.setParameter("dt2", sdf.parse(dt2));
        } catch (ParseException ex) {
            q.setParameter("dt2", new Date());
        }

        return q.getResultList();

    }

    public static Time buscarByID(int id) {

        Query q = getCon().createNamedQuery("Time.findByIdtime");

        q.setParameter("idtime", id);
        try {
            
            return (Time) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }

}
