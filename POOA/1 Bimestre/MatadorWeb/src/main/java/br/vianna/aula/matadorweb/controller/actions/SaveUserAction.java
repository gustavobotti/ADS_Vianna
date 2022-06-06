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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class SaveUserAction extends GenericCommander{

    public SaveUserAction(boolean isLogado) {
        super(isLogado);
    }
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        Usuario user = new Usuario(0, 
                request.getParameter("cpNome"), 
                request.getParameter("cpLogin"), 
                request.getParameter("cpSenha"));
        
        if ( UsuarioDao.existeLogin(user) ){            
            request.setAttribute("msgError", "Login já existe no sistema");
            
            user.setLogin("");
            request.setAttribute("user", user);
            
            
            new ViewCadastroAction(false).executa(request, response);            
        }else{        
        
            UsuarioDao.getCon().getTransaction().begin();
            UsuarioDao.getCon().persist(user);
            UsuarioDao.getCon().getTransaction().commit();

            request.setAttribute("msg", "Usuário criado com sucesso!!!");

            new  ViewLoginAction(false).executa(request, response);
        }
        
        
    }
    
}
