package br.vianna.exercicio3.servlet;

import br.vianna.exercicio3.model.ECabelos;
import br.vianna.exercicio3.model.EOlhos;
import br.vianna.exercicio3.model.ESexo;
import br.vianna.exercicio3.model.Pessoa;
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
@WebServlet(name = "PesquisaServlet", urlPatterns = {"/pesquisa"})
public class PesquisaServlet extends HttpServlet {

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
        
         int cpf = (Integer.parseInt(request.getParameter("cpCpf")));
         int idade = (Integer.parseInt(request.getParameter("cpIdade")));
         int altura = (Integer.parseInt(request.getParameter("cpAltura")));
         String olhos = request.getParameter("cpOlhos");
         String cabelos = request.getParameter("cpCabelos");
         String sexo = request.getParameter("cpSexo");     
        
         if (request.getSession().getAttribute("pessoas") == null){              
               
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            pessoas.add (new Pessoa(cpf, idade, altura, EOlhos.valueOf(olhos), ECabelos.valueOf(cabelos), ESexo.valueOf(sexo)));
            
            RequestDispatcher rd = request.getRequestDispatcher("pageExercicio3.jsp");       
            request.getSession().setAttribute("pessoas", pessoas);              
            rd.forward(request, response);  
               
         } else {             
             
            ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getSession().getAttribute("pessoas");
            
            pessoas.add (new Pessoa(cpf, idade, altura, EOlhos.valueOf(olhos), ECabelos.valueOf(cabelos), ESexo.valueOf(sexo)));
            
            RequestDispatcher rd = request.getRequestDispatcher("pageExercicio3.jsp");        
            request.getSession().setAttribute("pessoas", pessoas);              
            rd.forward(request, response);   
            
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
