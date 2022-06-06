/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.TarefaDAO;
import br.edu.vianna.todo.model.Tarefa;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class DeleteTaskAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            LoginUtil.verificaLogado(request, response);
            
            TarefaDAO td = new TarefaDAO();
            
            int id = Integer.parseInt(request.getParameter("id"));            
            
            Tarefa task = td.findById(id);
            
            td.apagar(task);
            
            request.setAttribute("msgAviso", "Tarefa apagada com sucesso!!");
                   
            new CallTaskListPageAction().executa(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msgAviso", "Não foi possível apagar a tarefa!");
                   
            new CallTaskListPageAction().executa(request, response);
        }
    }
    
}
