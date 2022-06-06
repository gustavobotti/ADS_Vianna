<%-- 
    Document   : pageEstado
    Created on : 21 de mar. de 2022, 19:14:21
    Author     : Aluno
--%>

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
                <div class="exercicio_thumb">
                    <div class="thumb_header">Exercício 1</div>
                    <div class="thumb_text">Um website que permita ao consumidor customizar a escolha de um carro novo
com seus opcionais, além de exibir o preço</div>
                    <img class="thumb_img" src="./img/unsplash.png" alt="swagstudent">
                </div>
                
                <div class="exercicio_ativo" style="text-align:center">
                    <h1>Bem vindo a concessionária virtual.</h1><br/> Para começar, escolha o tipo e modelo do seu carro, e depois, selecione os opcionais.
                    <br/> <br/><h3 style="color:black">Tipos: </h3>
                    <%
                        ArrayList<String> tipos = (ArrayList<String>) request.getAttribute("tipos");
                    %>
                    <form action="carroResultado" method="GET">
                        <select name="tipo" id ="cbTipo">
                            <% if (tipos != null) {
                                %>
                                <c:forEach items="${requestScope.tipos}" var="tip">
                                    <option >${tip}</option>
                                </c:forEach>
                            <%
                            }%>                       
                        </select>   <br/>
                        <select name="modelo" id="cbModelo">
                            
                        </select>
                        <br/><br/>
                        <h3 style="color:black">Escolha a pintura:</h3> 
                        Nenhuma<input type="radio" name="pintura" value="Nenhuma">
                        Especial<input type="radio" name="pintura" value="Especial">
                        Metalica<input type="radio" name="pintura" value="Metalica">
                        Comemorativa<input type="radio" name="pintura" value="Comemorativa"><br/><br/>
                        <h3 style="color:black">Escolha o motor</h3> 
                        1.0<input type="radio" name="motor" value="zero">
                        1.2<input type="radio" name="motor" value="dois">
                        1.4<input type="radio" name="motor" value="quatro">
                        1.6<input type="radio" name="motor" value="seis">
                        1.8<input type="radio" name="motor" value="oito">
                        2.0<input type="radio" name="motor" value="vinte">
                        <br/><br/>
                        <h3 style="color:black">Os opcionais são:</h3>
                        Ar <input type="checkbox" name="ar" value="Ar">
                        Cambio <input type="checkbox" name="cambio" value="Cambio">
                        Vidro <input type="checkbox" name="vidro" value="Vidro"> <br/>
                        Alarme <input type="checkbox" name="alarme" value="Alarme">
                        Solar <input type="checkbox" name="solar" value="Solar">
                        Multimidia <input type="checkbox" name="multimidia" value="Multimidia"><br/>
                        Importado <input type="checkbox" name="importado" value="Importado"><br/>
                        <button type="submit" >Enviar</button>
                    </form>
                </div>  <div class="about">
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
                         <script src="js/script.js" type="text/javascript"></script>
              
    </body>
</html>

