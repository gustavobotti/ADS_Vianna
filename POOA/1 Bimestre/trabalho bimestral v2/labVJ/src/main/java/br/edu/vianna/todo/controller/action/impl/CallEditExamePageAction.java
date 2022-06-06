/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.controller.action.impl.CallExameListPageAction;
import br.edu.vianna.todo.controller.action.impl.CallExamePageAction;
import br.edu.vianna.todo.dao.impl.ExameDAO;
import br.edu.vianna.todo.model.Exame;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class CallEditExamePageAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            LoginUtil.verificaLogado(request, response);
            
            ExameDAO td = new ExameDAO(); //validar se a exame é minha? daves: "no trabalho teremos que tomar cuidado com isso"
            
            int id = Integer.parseInt(request.getParameter("id"));            
            
            Exame exame = td.findById(id);
            
            request.setAttribute("exame", exame);
                   
            new CallExamePageAction().executa(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msgAviso", "Não foi possível alterar a exame!");
                   
            new CallExameListPageAction().executa(request, response);
        }
    }
    
}
