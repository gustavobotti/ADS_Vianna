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
public class SaveProfileAction extends GenericCommander {

    public SaveProfileAction(boolean b) {
        super(b);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        Usuario userSessao = (Usuario) request.getSession().getAttribute("user");
        
        int id = userSessao.getIdusuario();
        
        Usuario user = UsuarioDao.findById( id  );
        
        user.setNome( request.getParameter("cpNomeUser") );
        user.setLogin(request.getParameter("cpLoginUser") );
        user.setSenha(request.getParameter("cpSenhaUser") );
        
        if (UsuarioDao.existeLogin(user) && !user.getLogin().equals(userSessao.getLogin()) ){           
            request.setAttribute("msgError", "login já existe!!!");            
            new ViewProfileAction(true).executa(request, response);    
            return;
        }
        
        //salvar
        UsuarioDao.getCon().getTransaction().begin();
        UsuarioDao.getCon().persist(user);
        UsuarioDao.getCon().getTransaction().commit();
        
        request.setAttribute("msgSuccess", "Profile alterado com sucesso!!!"); 
        new ViewProfileAction(true).executa(request, response); 
        
    }
    
}
