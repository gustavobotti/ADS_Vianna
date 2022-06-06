
<%@page import="br.vianna.exercicio4.model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>
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
                    <div class="thumb_header">Exercício 4</div>
                    <div class="thumb_text">Um site para realizar uma votação para representante de turma, todos os alunos
podem ser votados e cada aluno tem direito a um voto.</div>
                    <img class="thumb_img" src="./img/unsplash.png" alt="swagstudent">
                </div>
                
                <div class="exercicio_ativo" style="text-align:center">
                    <form action="votar" method="GET">
                        <h2 id="listaAlunos">Voto para representante</h2> <br />
                        <h1>Bem vindo <%= session.getAttribute("nome") %> </h1> <br /> <br />
                        <% int votaramCounter = (Integer) session.getAttribute("votaramCounter"); %>
                        <% boolean votou = (boolean) session.getAttribute("votou"); %>
                        Lista de alunos:  <br />
                        <%
                            ArrayList<Aluno> alunos = (ArrayList<Aluno>) session.getAttribute("alunos");
                        %> 
                        <ul>
                        <% for (Aluno aluno : alunos) { %>
                              <li id="listaAlunos"> • <%= aluno %> - <%= aluno.getVotos()   %> </li>  
                        <%    }  %>                    
                        </ul> <br /> <p style="text-align:center ; color:black">
                        <% int maiorVoto = 0;
                              String vencedor = "";
                              int counter = 0;

                                for (int y = 0; y < alunos.size(); y++){
                                    if (alunos.get(y).getVotos() > maiorVoto){
                                        maiorVoto =  alunos.get(y).getVotos();
                                        vencedor =  alunos.get(y).getNome();
                                        counter = 0;
                                    } else if (alunos.get(y).getVotos() == maiorVoto
                                            && alunos.get(y).getVotos() > 0)
                                    {
                                        counter++;
                                    }

                                }
                                if (alunos.size() == votaramCounter){
                                   double result = maiorVoto * 1.0 / alunos.size() * 1.0;
                                   DecimalFormat df = new DecimalFormat("#.##");
                                   result *= 100;
                                   %>
                        <div class="card_result">                    
                        <div>
                            <img src="img/card.png" alt="imagem card"/>
                        </div>
                        <div>
                            <div class="cardTitle">Resultado:</div>
                            <div class="cardText"><%out.print("Aluno vencedor:");%></br><%
                                                                    out.print("O mais votado é "+vencedor+" com "+maiorVoto+" votos.");%></br><%
                                                                    out.print("Isso equivale a "+df.format(result)+"% dos votos.");%>
                                    </div>
                            <div class="cardOK"> OK </div>
                        </div>
                    </div>
                            <%
                                }%></p>
                        <br />     <br/>             
                    
                    <%
                        if (votou == true){
                            %>Você já votou<%
                        } else { %> Digite em quem vai votar. <br/> 
                                <input type="text" name="cpVoto" /> <br />
                                <br /><button type="submit">Votar</button> <% } %>
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

