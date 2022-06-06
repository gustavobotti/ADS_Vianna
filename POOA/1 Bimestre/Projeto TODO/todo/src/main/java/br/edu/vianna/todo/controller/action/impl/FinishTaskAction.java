/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.TarefaDAO;
import br.edu.vianna.todo.model.Tarefa;
import br.edu.vianna.todo.model.Usuario;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class FinishTaskAction implements ICommanderAction {
    
       @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try {
               LoginUtil.verificaLogado(request, response);
               
               int id = Integer.parseInt(request.getParameter("id"));
               Tarefa task = new TarefaDAO().findById(id);
               Usuario u = (Usuario) request.getSession().getAttribute("user");
               
               if (task.getUsuario().getId() != u.getId()){
                   request.setAttribute("msgAviso", "Tarefa não pertence ao usuário logado!");
                   
                   new CallTaskListPageAction().executa(request, response);
               } 
               if (task.isConcluida()){
                   request.setAttribute("msgAviso", "Tarefa já concluída!");
                   
                   new CallTaskListPageAction().executa(request, response);
               } 
               
               task.setConcluida(true);
               task.setDataFinalizada(new Date());
               
               new TarefaDAO().alterar(task);
               
               request.setAttribute("msgAviso", "Tarefa concluída com sucesso!");
                   
               new CallTaskListPageAction().executa(request, response);
           } catch (SQLException ex) {
                  request.setAttribute("msgAviso", "Tarefa não encontrada!");
                   
                  new CallTaskListPageAction().executa(request, response);
           }
    }
    
}
