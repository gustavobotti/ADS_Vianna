/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.controller.action.impl;

import br.edu.vianna.todo.controller.action.ICommanderAction;
import br.edu.vianna.todo.dao.impl.ExameDAO;
import br.edu.vianna.todo.dao.impl.UsuarioDAO;
import br.edu.vianna.todo.model.Exame;
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
public class SaveExameAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        LoginUtil.verificaLogado(request, response);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        
        Exame exame = null;
        try {
            exame = new Exame(0 , request.getParameter("cpDesc"),
                    false, 
                    sdf.parse(request.getParameter("cpDataPl")),
                    null, Double.parseDouble(request.getParameter("cpCusto")), Integer.parseInt(request.getParameter("cpJejum")));
        } catch (ParseException ex) {
            request.setAttribute("msgAviso", "Data planejada inválida!!");
            new CallExamePageAction().executa(request, response);
        }
        
        int cpf = Integer.parseInt(request.getParameter("cpUser"));
        try {
            Usuario user = new UsuarioDAO().findByCpf(cpf);
            exame.setUsuario(user);
            
        } catch (SQLException ex) {
            request.setAttribute("msg", "Erro ao encontrar usuário no banco!");
            new CallExamePageAction().executa(request, response);
        }       
       
        if (exame.getUsuario() != null){
            try {
                new ExameDAO().inserir(exame);
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro ao gravar exame no banco!");
                new CallExamePageAction().executa(request, response);
            }
        } else {
            request.setAttribute("msg", "Erro ao encontrar usuário no banco!");
            new CallExamePageAction().executa(request, response);
        }
        
        request.setAttribute("msgAviso", "Exame criado com sucesso!");
        
        new CallExameListPageAction().executa(request, response);
    }
    
}
