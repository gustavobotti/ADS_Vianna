<%-- 
    Document   : pageEstado
    Created on : 21 de mar. de 2022, 19:14:21
    Author     : Aluno
--%>

<%@page import="br.vianna.exercicio1.model.EMotor"%>
<%@page import="br.vianna.exercicio1.model.EPintura"%>
<%@page import="br.vianna.exercicio1.model.Carro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista Exercicios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>        
        <div class="container">
            <header class="header">
                <div class ="nav">
                <div class="title">POOA</div>                
                <nav class="menu">
                    <ul>
                         <li class="navOption"><a href="index.html">Home</a></li>
                         <li class="navOption"><a href="pageEx1">Exercício 1</a></li>
                         <li class="navOption"><a href="pageEx2">Exercício 2</a></li>
                         <li class="navOption"><a href="pageEx3">Exercício 3</a></li>
                         <li class="navOption"><a href="pageEx4">Exercício 4</a></li>      
                    </ul>
                </nav>    
                </div>
            </header> 
            
            <main>      
            
                <main>                 
                <div class="exercicio_thumb">
                    <div class="thumb_header">Exercício 1</div>
                    <div class="thumb_text">Um website que permita ao consumidor customizar a escolha de um carro novo
com seus opcionais, além de exibir o preço</div>
                    <img class="thumb_img" src="./img/unsplash.png" alt="swagstudent">
                </div>
                
                <div class="exercicio_ativo" style="text-align:center">
                    <%                         
                                Carro carro = (Carro) session.getAttribute("carro");
                    %> 
                    <h1>Bem vindo a concessionária virtual.</h1><br/> O carro escolhido foi <% out.print(carro.getTipo()+": "+carro.getModelo()); %>
                    <br/> <br/>
                    <%
                    double valorIPI = 0;
                    double custo = 10000;
                    double taxaImportacao = 0;

                    String temAr = "";
                    String temCambio = ""; // prof esqueceu de citar o valor do vidro automatico
                    String temAlarme = "";
                    String temSolar = "";
                    String temMult = "";
                    String temPintura = "";
                    String ehImportado = "";
                    
                    if(carro.isAr()){
                        custo = custo + 3000;
                        temAr = "Ar, ";         
                    }
                    if(carro.isCambio()){
                        custo = custo + 5000;
                        temCambio = "Cambio automatico, ";         
                    } 
                    if(carro.isAlarme()){
                        custo = custo + 800;
                        temAlarme = "Alarme, ";         
                    }
                    if(carro.isSolar()){
                        custo = custo + 4000;
                        temSolar = "Solar, ";         
                    }
                    if(carro.isMult()){
                        custo = custo + 1800;
                        temMult = "Kit Multimidia, ";         
                    }
                    if(carro.getPintura() == EPintura.valueOf("Nenhuma")){
                        custo = custo;
                    } else if (carro.getPintura() != EPintura.valueOf("Nenhuma")){
                        custo = custo + 2500;
                        temPintura = "Pintura editada,";
                    }  

                    if(carro.getMotor() == EMotor.valueOf("zero")){
                        valorIPI = custo * 10 / 100;
                        custo = custo + valorIPI;
                    } else {
                        valorIPI = custo * 20 / 100;
                        custo = custo + valorIPI;
                    }
                    if(carro.isImportado()){
                        taxaImportacao = custo * 30/100;
                        custo = custo + taxaImportacao;
                        
                        ehImportado = "É importado";
                    }
                    
                    %>
                    <div class="card_result">                    
                        <div>
                            <img src="img/card.png" alt="imagem card"/>
                        </div>
                        <div>
                            <div class="cardTitle">Resultado:</div>
                            <div class="cardText"><%
                    out.print("O custo do carro é de: R$"+custo+"\r\n");
                    if(carro.isImportado() || carro.isAr() || carro.isCambio() || carro.isAlarme() || carro.isMult() || carro.isSolar() || carro.isImportado()){
                    out.print("Ele tem os acessórios: "
                            +temAr+temCambio+temAlarme+temMult+temPintura+temSolar+ehImportado);
                    } else { %><br/><%
                        out.print("Ele não tem acessórios");
                        }
                    %></div>
                            <div class="cardOK"> OK </div>
                        </div>
                    </div>                  
                    
                    
                </div>   
                
                <div class="about">
                    <div class="aboutUs">
                        <div class="aboutUs_title">
                            <p>Know About US</p>
                            <p id="aboutUs_subtitle">Sobre</p>
                        </div>
                      <div class="aboutUs_card">                        
                        <div class="aboutUs_img">
                            <img src="./img/about.png" alt="aboutUs">
                        </div>
                        <div class="aboutUstext">
                            <p class="aboutUs_card_title">Join technology and mobility</p>
                            <p class="aboutUs_card_text">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugiat, eveniet. Minima hic ducimus corrupti, eligendi eum numquam temporibus quis, repellendus molestiae eveniet officia quod est velit aspernatur officiis facere assumenda maxime sunt adipisci quos, at doloribus tenetur quibusdam recusandae? Quaerat necessitatibus itaque id consequatur culpa totam repudiandae perspiciatis impedit dolor nemo molestias corporis nihil, ullam aperiam? Quas doloribus saepe perferendis eum laboriosam nesciunt aliquid optio quidem qui, provident expedita, reprehenderit sint enim ad aspernatur! Cupiditate, earum! Accusantium enim accusamus, libero sapiente qui architecto voluptas nobis, voluptatem dolor odio porro totam aperiam dolorem maiores praesentium dolores odit atque labore nulla. Vitae.</p>
                        </div>
                      </div>
                    </div>
              </div>
                
            </main>          
            
            
            
            <footer>                
                <div class="contato">
                    <div class="footer_aluno"><p class="footer_header">Aluno</p><p>Nome</p><p>Email</p></div>
                    <div class="footer_tarefa"><p class="footer_header">Tarefa</p><p>Apoio</p><p>Exemplo</p><p>Ajuda</p></div>
                    <div class="footer_social"><p class="footer_header">Stay connected</p><p><img src="./img/instagram.png" alt="instagram">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="./img/facebook.png" alt="facebook"></p></div>
                    <div class="footer_contato"><p class="footer_header">Contato</p><p>+55 32 97070-7070</p><p>hello@java.com.br</p></div>
                </div>
                <div class="trademark_footer"> <p>@ POOA - 2022 </p></div>
            </footer>     
                        
        </div>                        
              
    </body>
</html>

