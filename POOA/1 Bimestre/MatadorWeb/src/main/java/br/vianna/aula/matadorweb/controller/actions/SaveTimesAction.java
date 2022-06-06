/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class SaveTimesAction extends GenericCommander {

    public SaveTimesAction(boolean b) {
        super(b);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            TimeDao.getCon().getTransaction().begin();

            Time time;
            String msg;
            if (request.getParameter("cpId").equals("")) {

                time = new Time(0,
                        request.getParameter("cpNomeTime"),
                        sdf.parse(request.getParameter("cpFundacao")));

                time.setUsuario((Usuario) request.getSession().getAttribute("user"));
                msg = "Time criado com sucesso!!!";
            } else {
                
                time = TimeDao.buscarByID( Integer.parseInt(request.getParameter("cpId")) );
                
                time.setNome(request.getParameter("cpNomeTime"));
                time.setDataFundacao(sdf.parse(request.getParameter("cpFundacao")));
                msg = "Time alterado com sucesso!!!";
            }

            TimeDao.getCon().persist(time);
            
            TimeDao.getCon().getTransaction().commit();

            request.setAttribute("msg", msg);

            new ViewCadastroTimesAction(true).executa(request, response);
            
        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }

    }

}
