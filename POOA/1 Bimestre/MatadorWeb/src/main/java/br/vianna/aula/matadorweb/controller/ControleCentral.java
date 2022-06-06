/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller;

import br.vianna.aula.matadorweb.controller.actions.VerifyLoginAjaxAction;
import br.vianna.aula.matadorweb.controller.actions.SaveProfileAction;
import br.vianna.aula.matadorweb.controller.actions.ViewProfileAction;
import br.vianna.aula.matadorweb.controller.actions.SaveTimesAction;
import br.vianna.aula.matadorweb.controller.actions.ViewCadastroTimesAction;
import br.vianna.aula.matadorweb.controller.actions.LoginVerifyAction;
import br.vianna.aula.matadorweb.controller.actions.SaveUserAction;
import br.vianna.aula.matadorweb.controller.actions.ViewCadastroAction;
import br.vianna.aula.matadorweb.controller.actions.ViewHomeLogadoAction;
import br.vianna.aula.matadorweb.controller.actions.ViewListaTimesAction;
import br.vianna.aula.matadorweb.controller.actions.ViewLoginAction;
import br.vianna.aula.matadorweb.controller.actions.ViewLogoutAction;
import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
@WebServlet(name = "ControleCentral", urlPatterns = {"/control"})
public class ControleCentral extends HttpServlet {
    
    
    
    static HashMap<String, GenericCommander> comandos;
    
    static{
        comandos = new HashMap<>();
        
        comandos.put(null, new ViewLoginAction(false) );
        comandos.put("login", new LoginVerifyAction(false) );
        comandos.put("cad", new ViewCadastroAction(false) );      
        comandos.put("saveUser", new SaveUserAction(false) );      
        comandos.put("home", new ViewHomeLogadoAction(true) );      
        comandos.put("logout", new ViewLogoutAction(true) );      
        comandos.put("listaTimes", new ViewListaTimesAction(true) );      
        comandos.put("Times", new ViewCadastroTimesAction(true) );      
        comandos.put("timeCad", new SaveTimesAction(true) );      
        comandos.put("editTime", new ViewCadastroTimesAction(true) );      
        comandos.put("profile", new ViewProfileAction(true) );      
        comandos.put("saveProfile", new SaveProfileAction(true) );      
        comandos.put("verifyLoginAjax", new VerifyLoginAjaxAction(true) );      
        
    }        
           

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String acao = request.getParameter("ac");
            
            try {
                
                if (!comandos.get(acao).isSoExecuteComLogin() || request.getSession().getAttribute("user") != null ){
                    
                    comandos.get(acao).executa(request, response);                
                }else{
                    request.setAttribute("msg", "acesso não autorizado!!!");
                    new ViewLoginAction(false).executa(request, response);
                }
                
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                
                request.setAttribute("error", e.getMessage()==null?"ação não encontrada":e.getMessage());
                
                rd.forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
