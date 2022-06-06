/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.controller.action.impl.CallTaskListPageAction;
import br.edu.vianna.todo.controller.action.impl.CallTaskPageAction;
import br.edu.vianna.todo.dao.impl.TarefaDAO;
import br.edu.vianna.todo.model.Tarefa;
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
public class CallEditTaskPageAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            LoginUtil.verificaLogado(request, response);
            
            TarefaDAO td = new TarefaDAO(); //validar se a tarefa é minha? daves: "no trabalho teremos que tomar cuidado com isso"
            
            int id = Integer.parseInt(request.getParameter("id"));            
            
            Tarefa task = td.findById(id);
            
            request.setAttribute("task", task);
                   
            new CallTaskPageAction().executa(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msgAviso", "Não foi possível alterar a tarefa!");
                   
            new CallTaskListPageAction().executa(request, response);
        }
    }
    
}
