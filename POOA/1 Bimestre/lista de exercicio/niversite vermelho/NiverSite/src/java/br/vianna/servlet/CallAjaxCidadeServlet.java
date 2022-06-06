/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.jfr.ContentType;

/**
 *
 * @author Botti
 */
@WebServlet(name = "CallAjaxCidadeServlet", urlPatterns = {"/getCidades"})
public class CallAjaxCidadeServlet extends HttpServlet {

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
        response.setContentType("application/text;charset=UTF-8");
        
        Map<String, ArrayList<String>> cidades = new HashMap<>();
        
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Juiz de Fora");
        lista.add("Ubá");
        lista.add("Além Paraíba");
        cidades.put("MG", lista);
        lista = new ArrayList<>();
        lista.add("Rio de Janeiro");
        lista.add("Petrópolis");
        lista.add("Duque de Caxias");
        cidades.put("RJ", lista);
        lista = new ArrayList<>();
        lista.add("São Paulo");
        lista.add("Campinas");
        lista.add("Santos");
        cidades.put("SP", lista);
        lista = new ArrayList<>();
        lista.add("Anápolis");
        lista.add("Goiânia");
        lista.add("Posse");
        cidades.put("GO", lista);
        
        String est = request.getParameter("estado");
        
        try ( PrintWriter out = response.getWriter()) {
            String resp = "";
            for (String cid : cidades.get(est)) {
                resp += cid+";";
            }
            out.println(  resp  );
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
