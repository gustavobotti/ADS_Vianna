/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.vianna.exercicio1.servlet;

import br.vianna.exercicio1.model.Carro;
import br.vianna.exercicio1.model.EModelo;
import br.vianna.exercicio1.model.EMotor;
import br.vianna.exercicio1.model.EPintura;
import br.vianna.exercicio1.model.ETipo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
@WebServlet(name = "ForwardServlet", urlPatterns = {"/carroResultado"})
public class ForwardServlet extends HttpServlet {

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
        
        Carro carro = new Carro();
        
        String ar = request.getParameter("ar");
        String cambio = request.getParameter("cambio");
        String vidro = request.getParameter("vidro");
        String alarme = request.getParameter("alarme");
        String solar = request.getParameter("solar");
        String multimidia = request.getParameter("multimidia");
        String importado = request.getParameter("importado");
        
         String pintura = request.getParameter("pintura");
         String motor = request.getParameter("motor");
         String tipo = request.getParameter("tipo");
         String modelo = request.getParameter("modelo");
         
         
         if(ar != null && ar.equals("Ar")){
            carro.setAr(true);         
         }
         if(cambio != null && cambio.equals("Cambio")){
            carro.setCambio(true);         
         }
         if(vidro != null && vidro.equals("Vidro")){
            carro.setVidro(true);            
         }
         if(alarme != null && alarme.equals("Alarme")){
            carro.setAlarme(true);     
         }
         if(solar != null && solar.equals("Solar")){
            carro.setSolar(true);     
         }
         if(multimidia != null && multimidia.equals("Multimidia")){
            carro.setMult(true);     
         }         
         if(importado  != null && importado.equals("Importado")){
            carro.setImportado(true);     
         }
         //carro.setAr(true); 
         carro.setPintura(EPintura.valueOf(pintura));
         carro.setTipo(ETipo.valueOf(tipo));
         carro.setModelo(EModelo.valueOf(modelo));
         carro.setMotor(EMotor.valueOf(motor));
         
         RequestDispatcher rd = request.getRequestDispatcher("pageExercicio1resultado.jsp");          
         
         request.getSession().setAttribute("carro", carro);
         
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
