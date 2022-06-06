/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.commander;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public abstract class GenericCommander {
    
    private boolean soExecuteComLogin;

    public GenericCommander(boolean soExecuteComLogin) {
        this.soExecuteComLogin = soExecuteComLogin;
    }
    
    public abstract void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public boolean isSoExecuteComLogin() {
        return soExecuteComLogin;
    }

    public void setSoExecuteComLogin(boolean soExecuteComLogin) {
        this.soExecuteComLogin = soExecuteComLogin;
    }

    

    
    
        
}
