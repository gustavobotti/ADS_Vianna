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
@WebServlet(name = "LogarVotoServlet", urlPatterns = {"/login"})
public class LogarVotoServlet extends HttpServlet {

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
        
        String nome = request.getParameter("cpNome");
        
        
            if (request.getSession().getAttribute("alunos") == null){


               int votaramCounter = 0;
               ArrayList<Aluno> alunos = new ArrayList<>();
               alunos.add (new Aluno("Ze", false, 0));
               alunos.add (new Aluno("Ana", false, 0));
               alunos.add (new Aluno("Telles", false, 0));               
    //           alunos.add (new Aluno("Maria", false, 0));
    //           alunos.add (new Aluno("Gustavo", false, 0));
    //           alunos.add (new Aluno("Daves", false, 0));
    //           alunos.add (new Aluno("Um gato", false, 0));
    //           alunos.add (new Aluno("Kurt Cobain", false, 0));
    //           alunos.add (new Aluno("Doguinho Caramelo", false, 0));
    //           alunos.add (new Aluno("Darth Vader", false, 0));

            int i = 0;
            
            
            for(Aluno aluno : alunos){
                String a = aluno.getNome();
                i++;
                if (a.equals(nome)){
                     RequestDispatcher rd = request.getRequestDispatcher("pageExercicio4logado.jsp");      
                     
                     boolean votou = aluno.isVotou();

                     request.getSession().setAttribute("nome", nome);
                     request.getSession().setAttribute("votou", votou);
                     request.getSession().setAttribute("aluno", aluno);
                     request.getSession().setAttribute("logado", true);
                     request.getSession().setAttribute("alunos", alunos); 
                     request.getSession().setAttribute("votaramCounter", votaramCounter); 


                     rd.forward(request, response);   
                } else if (i+1 > alunos.size()){ 
                    request.getSession().setAttribute("logado", false);
                    response.sendRedirect("index.html");
                    return;
                }
            }   
        } else {
            ArrayList<Aluno> alunos = (ArrayList<Aluno>) request.getSession().getAttribute("alunos");
            int votaramCounter = (Integer) request.getSession().getAttribute("votaramCounter");
            for(Aluno aluno : alunos){
            int i = 0;
            String a = aluno.getNome();
            i++;
            if (a.equals(nome)){
                 RequestDispatcher rd = request.getRequestDispatcher("pageExercicio4logado.jsp");          
                 
                 boolean votou = aluno.isVotou();

                 request.getSession().setAttribute("nome", nome);
                 request.getSession().setAttribute("votou", votou);
                 request.getSession().setAttribute("logado", true);      
                 request.getSession().setAttribute("aluno", aluno);
                 request.getSession().setAttribute("alunos", alunos); 
                 request.getSession().setAttribute("votaramCounter", votaramCounter); 
                 


                 rd.forward(request, response);   
            }
            if (i+1 > alunos.size()){ 
                request.getSession().setAttribute("logado", false);
                response.sendRedirect("index.html");
                return;
            }
            
        }
        
    }}

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
