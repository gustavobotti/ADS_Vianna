/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class LoginVerifyAction extends GenericCommander {

    public LoginVerifyAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{

        try {
            String email = request.getParameter("cpEmail");
            String senha = request.getParameter("cpSenha");
            
            Usuario u = new UsuarioDao().verifiyUser(email, senha);
                        
            if ( u != null  ) {
                
                Usuario user = new Usuario(u.getIdusuario());
                user.setNome(u.getNome());
                user.setLogin(u.getLogin());
                user.setEhAdm(u.getEhAdm());
                
                request.getSession().setAttribute("user", user);
                                
                new ViewHomeLogadoAction(true).executa(request, response);
                
            } else {
                response.sendRedirect("control?error=1");
            }
        } catch (SQLException ex) {
            throw new ServerException(ex.getMessage());
        }

    }

}
