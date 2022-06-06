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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class CallTaskListPageAction implements ICommanderAction {

    public CallTaskListPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         LoginUtil.verificaLogado(request, response);
        
         Usuario u = (Usuario) request.getSession().getAttribute("user");
         
         List<Tarefa> tarefas = new TarefaDAO().findMinhasTarefas( u.getId() );
         
         request.setAttribute("tarefas", tarefas);
         
         RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=listTask");
         rd.forward(request, response);
    }
    
}
