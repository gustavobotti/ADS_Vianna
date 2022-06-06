/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.UsuarioDAO;
import br.edu.vianna.todo.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Aluno
 */
public class VerifyLoginAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        try {
            String cpf = request.getParameter("cpCpf");
            String senha = request.getParameter("cpSenha");

            Usuario user = new UsuarioDAO().findByCpfAndSenha(cpf, senha);

            if (user == null) {
                request.setAttribute("msg", "Login ou Senha incorreta!!!");
                new CallLoginPageAction().executa(request, response);
            } else {
                
                request.getSession().setAttribute("user", user);
                new CallHomeLogadoPageAction().executa(request, response);
                
            }
        } catch (SQLException ex) {
            new CallErrorPageAction("Não foi possível conectar ou " +
              "executar a consulta no banco <br /><br/>"
             + "<b>"+ex.getMessage()+"</b>").executa(request, response);
        }

    }

}
