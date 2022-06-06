package br.vianna.servlet;

import br.vianna.model.EPlano;
import static br.vianna.model.EPlano.Nenhum;
import static br.vianna.model.EPlano.PlanMed;
import static br.vianna.model.EPlano.SaudeMais;
import br.vianna.model.ESexo;
import static br.vianna.model.ESexo.Feminino;
import static br.vianna.model.ESexo.Masculino;
import static br.vianna.model.ESexo.Outro;
import br.vianna.model.ETipo;
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
@WebServlet(name = "RegistraClienteServlet", urlPatterns = {"/regCliente"})
public class RegistraClienteServlet extends HttpServlet {

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
        String nome = request.getParameter("cpNome");
        String telefone = request.getParameter("cpTel");
        String endereco = request.getParameter("cpEnd");
        int cpf = Integer.parseInt(request.getParameter("cpCPF"));
        String plano = request.getParameter("cpPlano");
        String sexo = request.getParameter("cpSexo");
        String tipo = "Cliente";
        
        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getSession().getAttribute("pessoas");
        
        Pessoa p = new Pessoa(nome,telefone,endereco,ESexo.valueOf(sexo),EPlano.valueOf(plano),ETipo.valueOf(tipo),cpf,login,senha);
        pessoas.add(p);
        
        RequestDispatcher rd = request.getRequestDispatcher("pageAtendente.jsp");        
        request.getSession().setAttribute("pessoas", pessoas);              
        rd.forward(request, response);   
            
        
        
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
