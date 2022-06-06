/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.UsuarioDAO;
import br.edu.vianna.todo.model.Usuario;
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
public class SaveUserAction implements ICommanderAction {

    public SaveUserAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = new Usuario(0 , request.getParameter("cpNome"),
        request.getParameter("cpEmail"),
        request.getParameter("cpLogin"),
        request.getParameter("cpSenha"), new Date());
        
        if (user.getNome().isEmpty() || user.getNome().trim().isEmpty()){
            request.setAttribute("msg", "nome não pode ser vazio!");
            request.setAttribute("user", user);
            new CallCreateUserPageAction().executa(request, response);
        }
        
        try {
            new UsuarioDAO().inserir(user);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Nome não pode ser vazio!");
            request.setAttribute("user", user);
            new CallCreateUserPageAction().executa(request, response);
        }
        
        request.setAttribute("msgAviso", "Usuário criado com sucesso!");
        
        new CallLoginPageAction().executa(request, response);
    }
    
}
