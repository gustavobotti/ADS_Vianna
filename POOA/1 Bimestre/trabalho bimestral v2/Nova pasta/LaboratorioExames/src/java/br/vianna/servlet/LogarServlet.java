package br.vianna.servlet;

import static br.vianna.model.EPlano.Nenhum;
import static br.vianna.model.EPlano.PlanMed;
import static br.vianna.model.EPlano.SaudeMais;
import static br.vianna.model.ESexo.Feminino;
import static br.vianna.model.ESexo.Masculino;
import static br.vianna.model.ESexo.Outro;
import static br.vianna.model.ETipo.Admin;
import static br.vianna.model.ETipo.Atendente;
import static br.vianna.model.ETipo.Cliente;
import br.vianna.model.Exame;
import br.vianna.model.Pessoa;
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
@WebServlet(name = "LogarServlet", urlPatterns = {"/logar"})
public class LogarServlet extends HttpServlet {

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
        
        String login = request.getParameter("cpLogin");
        String senha = request.getParameter("cpSenha");
        
        
            if (request.getSession().getAttribute("pessoas") == null){

                
               ArrayList<Pessoa> pessoas = new ArrayList<>();
               pessoas.add (new Pessoa("Ze", "3232-3232", "Rua dos Palmares", Masculino, Nenhum, Cliente, 1234567890, "ze", "ze1"));
               pessoas.add (new Pessoa("Ana", "3131-3131", "Rua das Maritacas", Feminino, SaudeMais, Atendente, 1234567899, "ana", "ana1"));
               pessoas.add (new Pessoa("Telles", "3333-3333", "Rua Tres", Outro, PlanMed, Admin, 1234567898, "telles", "telles1"));               
    //           pessoas.add (new Pessoa("Maria", false, 0));
    //           pessoas.add (new Pessoa("Gustavo", false, 0));
    //           pessoas.add (new Pessoa("Daves", false, 0));
    //           pessoas.add (new Pessoa("Um gato", false, 0));
    //           pessoas.add (new Pessoa("Kurt Cobain", false, 0));
    //           pessoas.add (new Pessoa("Doguinho Caramelo", false, 0));
    //           pessoas.add (new Pessoa("Darth Vader", false, 0));
                ArrayList<Exame> exames = new ArrayList<>();

            int i = 0;
            
            
            for(Pessoa pessoa : pessoas){
                String l = pessoa.getLogin();                
                String s = pessoa.getSenha();
                i++;
                if (l.equals(login) && s.equals(senha)){
                    if(pessoa.getTipo().equals(Cliente)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageCliente.jsp");      


                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else if(pessoa.getTipo().equals(Atendente)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageAtendente.jsp");      


                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else if(pessoa.getTipo().equals(Admin)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageAdmin.jsp");      


                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("pageCliente.jsp");      


                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    }
                } else if (i+1 > pessoas.size()){ 
                    request.getSession().setAttribute("logado", false);
                    response.sendRedirect("index.html");
                    return;
                }
            }   
        } else {
            ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getSession().getAttribute("pessoas");
            ArrayList<Exame> exames = (ArrayList<Exame>) request.getSession().getAttribute("exames");
            for(Pessoa pessoa : pessoas){
            int i = 0;
            String l = pessoa.getLogin();
            String s = pessoa.getSenha();
            i++;
            if (l.equals(login) && s.equals(senha)){
                 if(pessoa.getTipo().equals(Cliente)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageCliente.jsp");      


                        request.getSession().setAttribute("nome", pessoa.getNome());
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else if(pessoa.getTipo().equals(Atendente)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageAtendente.jsp");      


                        request.getSession().setAttribute("nome", pessoa.getNome());
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else if(pessoa.getTipo().equals(Admin)){
                        RequestDispatcher rd = request.getRequestDispatcher("pageAdmin.jsp");      


                        request.getSession().setAttribute("nome", pessoa.getNome());
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("pageCliente.jsp");      


                        request.getSession().setAttribute("nome", pessoa.getNome());
                        request.getSession().setAttribute("pessoa", pessoa);
                        request.getSession().setAttribute("logado", true);
                        request.getSession().setAttribute("pessoas", pessoas); 
                        request.getSession().setAttribute("exames", exames); 


                        rd.forward(request, response);   
                    }
            } else if (i+1 > pessoas.size()){ 
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
