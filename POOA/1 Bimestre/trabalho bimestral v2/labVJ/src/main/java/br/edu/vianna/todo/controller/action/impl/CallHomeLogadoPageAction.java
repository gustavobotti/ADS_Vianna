/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.ExameDAO;
import br.edu.vianna.todo.model.Exame;
import br.edu.vianna.todo.model.Usuario;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CallHomeLogadoPageAction implements ICommanderAction{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         LoginUtil.verificaLogado(request, response);         
         

         RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=HomeLogado");

         rd.forward(request, response);
    
    }    
    
}
