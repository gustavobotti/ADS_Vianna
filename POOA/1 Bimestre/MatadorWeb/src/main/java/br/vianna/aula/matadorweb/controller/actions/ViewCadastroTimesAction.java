/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class ViewCadastroTimesAction extends GenericCommander {

    public ViewCadastroTimesAction(boolean b) {
        super(b);
    }
    
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
        
        String titulo;
        Time tBusca = new Time();
        tBusca.setDataFundacao(new Date());
        if (request.getParameter("id")!=null){
            titulo = "Alterar Time";
            tBusca = TimeDao.buscarByID( Integer.parseInt(request.getParameter("id")) );
        }else{
            titulo = "Novo Time";
        }                
        
        request.setAttribute("time", tBusca);
        request.setAttribute("titulo", titulo);
        request.setAttribute("page", "/pages/times/time.jsp");
        rd.forward(request, response);
    }
}
