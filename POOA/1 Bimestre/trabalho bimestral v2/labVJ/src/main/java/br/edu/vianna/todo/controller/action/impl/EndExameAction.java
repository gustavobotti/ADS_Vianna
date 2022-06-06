/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.ExameDAO;
import br.edu.vianna.todo.model.Exame;
import br.edu.vianna.todo.util.LoginUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Botti
 */
public class EndExameAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginUtil.verificaLogado(request, response);        
        
        ExameDAO ed = new ExameDAO();
        
        int id = Integer.parseInt(request.getParameter("cpCodigo"));
        int cpf = Integer.parseInt(request.getParameter("cpUser"));
        
        
        try {
           Exame exame = ed.findById(id);          
           
           if(exame != null){
                if (exame.isConcluida() == false && exame.getUsuario().getCpf() == cpf){
                     Date d = new Date();
                     exame.setConcluida(true);
                     exame.setDataFinalizada(d);

                     new ExameDAO().alterar(exame);
                } else {
                 request.setAttribute("msg", "Erro ao alterar a exame no banco: CPF ERROR!");
                 new CallExamePageAction().executa(request, response);           
                }
           } else { 
               request.setAttribute("msg", "Erro ao alterar a exame no banco: EXAME NÃO ENCONTRADO!");
               new CallExamePageAction().executa(request, response);
           }
        } catch (SQLException ex) {
            request.setAttribute("msg", "Erro ao alterar a exame no banco: EXAME NÃO ENCONTRADO!");
            new CallExamePageAction().executa(request, response);
        }
        
        request.setAttribute("msgAviso", "Exame finalizado com sucesso!");
        
        new CallExameListPageAction().executa(request, response);
    }
    
}
