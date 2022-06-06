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
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class ViewListaTimesAction extends GenericCommander{

    public ViewListaTimesAction(boolean soExecuteComLogin) {
        super(soExecuteComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
                
        request.setAttribute("page", "/pages/times/listaTime.jsp");
        
        List<Time> times = null;
        if (request.getParameter("cpSearchNome") == null){
            times =TimeDao.buscarTimesUsuario( (Usuario) request.getSession().getAttribute("user") );
        }else{
            Usuario u = new Usuario( Integer.parseInt( request.getParameter("cpSearchUser") ) );
            String dt1 = request.getParameter("cpdata1"); //yyyy-MM-dd
            String dt2 = request.getParameter("cpdata2");
                        
            times =  TimeDao.buscarTimesFiltro( request.getParameter("cpSearchNome"), u ,
                    dt1, dt2);
            
        }
        
        request.setAttribute("times", times );
        request.setAttribute("usuarios", UsuarioDao.buscarTodos() );
        
        //request.setAttribute("cor", "text-danger");
        
        rd.forward(request, response);
        
    }
    
}
