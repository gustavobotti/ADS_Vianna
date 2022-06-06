/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.servlet;

import br.vianna.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "PaginaServlet", urlPatterns = {"/pagina"})
public class PaginaServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            Pessoa pes = new Pessoa(request.getParameter("cpNome"),
                    Double.parseDouble(request.getParameter("cpPeso")),
                    Double.parseDouble(request.getParameter("cpAltura"))
            );

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PaginaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Olá "+pes.getNome()+", bem vindo ao IMC calculator</h1>");
//            out.println("<h4>peso "+pes.getPeso()+"</h4>");
//            out.println("<h4>altura "+pes.getAltura()+"</h4>");
//            out.println("<h4>imc "+pes.imc()+"</h4>");
//            out.println("</body>");
//            out.println("</html>");
            out.print("<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        \n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\" integrity=\"sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n"
                    + "        \n"
                    + "        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        \n"
                    + "        <div class=\"container\">\n"
                    + "            <header>\n"
                    + "               \n"
                    + "                <div>                \n"
                    + "                    <img src=\"img/logo.svg\" />                                            \n"
                    + "                </div>\n"
                    + "                \n"
                    + "                <div class=\"title\">niverSite</div>\n"
                    + "                \n"
                    + "                <div>\n"
                    + "                \n"
                    + "                    <i class=\"fa-solid fa-circle-question\"></i>\n"
                    + "                    \n"
                    + "                </div>\n"
                    + "                \n"
                    + "            </header> \n"
                    + "            \n"
                    + "            <main>      \n"
                    + "            \n"
                    + "                <h1>Olá "+pes.getNome()+", bem vindo ao IMC calculator</h1>\n"
                    + "                <h4>imc "+pes.imc()+"</h4>\n"
                    + "            </main>\n"
                    + "            \n"
                    + "            <footer>\n"
                    + "                zzzzz\n"
                    + "            </footer>\n"
                    + "                        \n"
                    + "        </div>\n"
                    + "              \n"
                    + "    </body>\n"
                    + "</html>");
            
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
