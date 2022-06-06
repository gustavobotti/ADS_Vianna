/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.CategoriaDAO;
import br.edu.vianna.todo.dao.impl.TarefaDAO;
import br.edu.vianna.todo.model.Categoria;
import br.edu.vianna.todo.model.Tarefa;
import br.edu.vianna.todo.model.Usuario;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class CallTaskPageAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            LoginUtil.verificaLogado(request, response);
            
            List<Categoria> categorias = new CategoriaDAO().findAll();
            
            request.setAttribute("categorias", categorias);
            
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=cadTask");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CallTaskPageAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
