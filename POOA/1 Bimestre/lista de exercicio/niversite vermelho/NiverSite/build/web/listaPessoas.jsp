<%@page import="br.vianna.model.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="container">
            <header>
               
                <div>                
                    <img src="img/logo.svg" />                                            
                </div>
                
                <div class="title">niverSite</div>
                
                <div>
                
                    <i class="fa-solid fa-circle-question"></i>
                    
                </div>
                
            </header> 
            
            <main>   
                
                 <h1>Bem vindo <%= session.getAttribute("nome") %> </h1> 
            
                <%
                    ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("lista");
                %>
                
                <ul>
                    <% for (Pessoa pessoa : pessoas) { %>
                          <li> <%= pessoa.getNome()   %> </li>  
                    <%    }  %>                    
                </ul>
                
                
                
            </main>
            
            <footer>
                zzzzz
            </footer>
                        
        </div>
              
    </body>
</html>


