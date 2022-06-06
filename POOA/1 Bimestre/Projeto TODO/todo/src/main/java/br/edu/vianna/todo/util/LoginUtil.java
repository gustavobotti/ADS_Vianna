/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.util;

import br.edu.vianna.todo.controller.action.impl.CallLoginPageAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class LoginUtil {
    
    public static void verificaLogado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null){
            
            request.setAttribute("msgAviso", "Acesso não autorizado!");
            
            new CallLoginPageAction().executa(request, response);
        }
    }
}
