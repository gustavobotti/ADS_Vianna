/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.controller;

import br.edu.vianna.todo.controller.action.impl.SaveEditedTaskAction;
import br.edu.vianna.todo.controller.action.impl.CallEditTaskPageAction;
import br.edu.vianna.todo.controller.action.impl.DeleteTaskAction;
import br.edu.vianna.todo.controller.action.impl.FinishTaskAction;
import br.edu.vianna.todo.controller.action.impl.SaveTaskAction;
import br.edu.vianna.todo.controller.action.impl.CallTaskPageAction;
import br.edu.vianna.todo.controller.action.impl.CallTaskListPageAction;
import br.edu.vianna.todo.controller.action.impl.LogoutAction;
import br.edu.vianna.todo.controller.action.impl.SaveUserAction;
import br.edu.vianna.todo.controller.action.impl.CallCreateUserPageAction;
import br.edu.vianna.todo.controller.action.impl.VerifyLoginAction;
import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.controller.action.impl.CallErrorPageAction;
import br.edu.vianna.todo.controller.action.impl.CallErrorPageAction;
import br.edu.vianna.todo.controller.action.impl.CallHomeLogadoPageAction;
import br.edu.vianna.todo.controller.action.impl.CallHomeLogadoPageAction;
import br.edu.vianna.todo.controller.action.impl.CallHomePageAction;
import br.edu.vianna.todo.controller.action.impl.CallHomePageAction;
import br.edu.vianna.todo.controller.action.impl.CallLoginPageAction;
import br.edu.vianna.todo.controller.action.impl.CallLoginPageAction;
import br.edu.vianna.todo.controller.action.impl.VerifyLoginAction;
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
 * @author Aluno
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/control"})
public class ControleServlet extends HttpServlet {

    static final HashMap<String, ICommanderAction > comandos = new HashMap<>();

    public ControleServlet() {
        if (comandos.isEmpty()){
        comandos.put(null, new CallHomePageAction());
        comandos.put("home", new CallHomePageAction());
        comandos.put("login", new CallLoginPageAction());
        comandos.put("verifyLogin", new VerifyLoginAction());            
        comandos.put("logado", new CallHomeLogadoPageAction());            
        comandos.put("create", new CallCreateUserPageAction());            
        comandos.put("saveUser", new SaveUserAction());            
        comandos.put("logout", new LogoutAction());            
        comandos.put("task", new CallTaskListPageAction());            
        comandos.put("newTask", new CallTaskPageAction());            
        comandos.put("saveTask", new SaveTaskAction());            
        comandos.put("finishTask", new FinishTaskAction());            
        comandos.put("delTask", new DeleteTaskAction());            
        comandos.put("editTask", new CallEditTaskPageAction());            
        comandos.put("saveEditedTask", new SaveEditedTaskAction());            
        }
    }    
    static {
        comandos.put(null, new CallHomePageAction());
        comandos.put("home", new CallHomePageAction());
        comandos.put("login", new CallLoginPageAction());
        comandos.put("verifyLogin", new VerifyLoginAction());          
        comandos.put("logado", new CallHomeLogadoPageAction());     
        comandos.put("create", new CallCreateUserPageAction());        
        comandos.put("saveUser", new SaveUserAction());         
        comandos.put("logout", new LogoutAction());  
        comandos.put("task", new CallTaskListPageAction());             
        comandos.put("newTask", new CallTaskPageAction());           
        comandos.put("saveTask", new SaveTaskAction());          
        comandos.put("finishTask", new FinishTaskAction());              
        comandos.put("delTask", new DeleteTaskAction());        
        comandos.put("editTask", new CallEditTaskPageAction());         
        comandos.put("saveEditedTask", new SaveEditedTaskAction());                                  
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

        String ac = request.getParameter("ac");

        try {
            //podeAcessar() ?!
            comandos.get(ac).executa(request, response);
        } catch (Exception e) {
             new CallErrorPageAction("Ocorreu um erro interno no sistema!!!"
             + " <br /><br/>"
             + "<b>"+e.getMessage()+"</b>").executa(request, response);
        }
        
        
//        if (ac == null) {
//            new CallHomePageAction().executa(request, response);
//        } else if (ac.equals("login")) {
//            new CallLoginPageAction().executa(request, response);
//        }

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
