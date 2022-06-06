<%-- 
    Document   : pageEstado
    Created on : 21 de mar. de 2022, 19:14:21
    Author     : Aluno
--%>

<%@page import="br.vianna.exercicio3.model.Pessoa"%>
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
                    <div class="thumb_header">Exercício 3</div>
                    <div class="thumb_text">Um site para pesquisa sobre algumas características físicas da população de
uma determinada região</div>
                    <img class="thumb_img" src="./img/unsplash.png" alt="swagstudent">
                </div>
                
                <div class="exercicio_ativo" style="text-align:center">
                    <form action="pesquisa" method="POST">
                        <h2 id="listaAlunos">Pesquisa IBVJ</h2> 
                        <%                            
                                ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) session.getAttribute("pessoas");
                        %> 
                        <h6 id="listaAlunos"><% if (request.getSession().getAttribute("pessoas") != null){out.print(pessoas.size());} else { out.print(0);}%> pessoas cadastradas</h6><br/>
                        CPF: <input type="number" name="cpCpf" /> <br />
                        Idade: <input type="number" name="cpIdade" /> <br />
                        Altura em cm: <input type="number" name="cpAltura" /> <br />
                        Cor dos olhos:     <select name="cpOlhos" id="listaAlunos">
                                                        <option value="Azuis">Azuis</option>
                                                        <option value="Verdes">Verdes</option>
                                                        <option value="Castanhos">Castanhos</option>
                                                    </select><br />
                        Cor dos cabelos: <select name="cpCabelos" id="listaAlunos">
                                                        <option value="Louros">Louros</option>
                                                        <option value="Castanhos">Castanhos</option>
                                                        <option value="Pretos">Pretos</option>
                                                   </select><br />
                        Sexo:                       <select name="cpSexo" id="listaAlunos">
                                                        <option value="Masculino">Masculino</option>
                                                        <option value="Feminino">Feminino</option>
                                                   </select><br />
                        <br />
                        <button type="submit" >Registrar pessoa</button>                  
                    </form><br/>
                    <form action="pesquisaResultado" method="GET">
                            <button type="submit" >Mostrar resultados</button>
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
              
    </body>
</html>

