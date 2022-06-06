package br.vianna.servlet;

import br.vianna.model.Exame;
import br.vianna.model.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "EntregaExameServlet", urlPatterns = {"/entrega"})
public class EntregaExameServlet extends HttpServlet {

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
        
        int codigo = Integer.parseInt(request.getParameter("cpCod"));
        
        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getSession().getAttribute("pessoas");
        ArrayList<Exame> exames = (ArrayList<Exame>) request.getSession().getAttribute("exames");
        
        int i = -1;
        
        for(Exame exame : exames){
            int c = exame.getCodigo();
            i++;
            if (c == codigo){ 
                exame.setJaFoiEntregue(true);
                
        
                RequestDispatcher rd = request.getRequestDispatcher("pageAtendente.jsp");        
                request.getSession().setAttribute("pessoas", pessoas);                      
                request.getSession().setAttribute("exame", exame);         
                request.getSession().setAttribute("exames", exames);           
                rd.forward(request, response);   
            } else
                if (i+2 > exames.size()){ 
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
