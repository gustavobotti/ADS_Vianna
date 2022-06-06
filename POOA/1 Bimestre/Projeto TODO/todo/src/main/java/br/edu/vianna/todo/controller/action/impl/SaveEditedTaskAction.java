/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.TarefaDAO;
import br.edu.vianna.todo.model.Categoria;
import br.edu.vianna.todo.model.Tarefa;
import br.edu.vianna.todo.model.Usuario;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class SaveEditedTaskAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginUtil.verificaLogado(request, response);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        
        TarefaDAO td = new TarefaDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        try {
           Tarefa task = td.findById(id);
           
           task.setDescricao(request.getParameter("cpDesc"));
           task.setCategoria(new Categoria (Integer.parseInt(request.getParameter("cpCate")) , "", ""));
           try{
                task.setDataPlanejada(sdf.parse(request.getParameter("cpDataPl")));
           } catch (ParseException ex) {
            request.setAttribute("msgAviso", "Data planejada inválida!!");
            new CallTaskPageAction().executa(request, response);
           }
           
           new TarefaDAO().alterar(task);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Erro ao alterar a tarefa no banco!");
            new CallTaskPageAction().executa(request, response);
        }
        
        request.setAttribute("msgAviso", "Tarefa criada com sucesso!");
        
        new CallTaskListPageAction().executa(request, response);
    }
    
}
