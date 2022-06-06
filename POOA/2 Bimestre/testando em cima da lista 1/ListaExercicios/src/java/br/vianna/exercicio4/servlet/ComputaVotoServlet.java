/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.exercicio4.servlet;

import br.vianna.exercicio4.model.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Botti
 */
@WebServlet(name = "ComputaVotoServlet", urlPatterns = {"/votar"})
public class ComputaVotoServlet extends HttpServlet {

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
        
        String voto = request.getParameter("cpVoto");
        
        ArrayList<Aluno> alunos =  (ArrayList<Aluno>)  request.getSession().getAttribute("alunos");
        Aluno logado = (Aluno) request.getSession().getAttribute("aluno");
        int votaramCounter = (Integer) request.getSession().getAttribute("votaramCounter");
        
        //
        int i = -1;
        for(Aluno aluno : alunos){
                String a = aluno.getNome();
                i++;
                if (logado.isVotou() == false && a.equals(voto)){

                     alunos.get(i).setVotos(alunos.get(i).getVotos()+1);
                     logado.setVotou(true);    
                     
                     votaramCounter++;



                     RequestDispatcher rd = request.getRequestDispatcher("pageExercicio4.jsp");   

                     request.getSession().setAttribute("nome", null);
                     request.getSession().setAttribute("logado", false);   
                     request.getSession().setAttribute("alunos", alunos);
                     request.getSession().setAttribute("votaramCounter", votaramCounter);  


                     rd.forward(request, response);   
                } else
                if (i+2 > alunos.size()){ 
                    response.sendRedirect("index.html");
                    return;
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
