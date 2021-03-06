<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.vianna.aula.matadorweb.model.Usuario"%>
<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml" >
    <head>
        <title>Matador Web 1.0</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/favicon.ico"  />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic.min.css" integrity="sha512-LeCmts7kEi09nKc+DwGJqDV+dNQi/W8/qb0oUSsBLzTYiBwxj0KBlAow2//jV7jwEHwSCPShRN2+IWwWcn1x7Q==" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/home.css" />
        <!--===============================================================================================-->

    </head>
    <body>

        <header>
            <nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="btn btn-dark navbar-toggle pull-left menu-toggle"  data-target="#side-bar">
                            <i class="oi oi-menu"></i>
                        </button>
                        <a class="navbar-brand " href="#">Matador web</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="layout-main"> 

            <aside class="wrapper" id="side-bar">
                <nav id="menu" class="sidebar sidebar-open">
                    <ul class="nav nav-pills">
                        <li class="nav-item"><a class="nav-link " href="control?ac=home"> <i
                                    class="oi oi-home"></i> <span>Home</span>
                            </a></li>
                    </ul>
                    
                        <ul class="nav nav-pills" sec:authorize="hasRole('ADMIN')" >
                            <li class="nav-item"><span class="nav-link active" >Administra??o</span></li>

                            <li class="nav-item">
                                <a class="nav-link"
                                   href="control?ac=Times"> <i class="oi oi-cart"></i> <span>Cadastro Times</span>
                                </a>
                            </li>                           
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="control?ac=listaTimes"> <i class="oi oi-cart"></i> <span>Times</span>
                                </a>
                            </li>                           
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="#"> <i class="oi oi-cart"></i> <span>Relat?rios</span>
                                </a>
                            </li>                           
                        </ul>
                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active" >Geral</span></li>
                        <li class="nav-item">
                            <a class="nav-link " href="control?ac=profile"> <i class="oi oi-spreadsheet"></i>
                                    <span>Meus Dados</span>
                            </a>
                        </li>
                        <li class="nav-item"><span class="nav-link active" >Jogos</span></li>
                        <li class="nav-item">
                            <a class="nav-link " href="#"> <i class="oi oi-spreadsheet"></i>
                                    <span>Joadores</span>
                            </a>
                        </li>

                        <li class="nav-item" >
                            <a class="nav-link " href="control?ac=logout"> 
                                <i class="oi oi-account-logout"></i> <span>Sair</span>
                            </a>
                        </li>

                    </ul>

                </nav>
            </aside>
            
            <% 
                Usuario u = (Usuario)session.getAttribute("user");
            %>

            
            
            <section class="row container-fluid"  >
                <div class="col-12">
                    <h1>Ol? <%= u.getNome() %></h1>
                    
                    <h1>Ol? <c:out value="${sessionScope.user.nome}" /> 
                        <small>${sessionScope.user.tipoPermissao()}</small>
                    </h1>
                    
                    
                    
                </div>
                    <div class="col-12 justify-content-md-center text-center">
                        <img src="images/jogo.jpg" alt="alt"/>
                        
                    </div>
            </section>

        </div>
        <footer class="layout-footer">
            <div class="container">
                <span class="footer-copy">&copy; 2021 Matador Web. Todos os direitos reservados.</span>
            </div>
        </footer> 

        <!-- Bootstrap core JavaScript
                ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!--===============================================================================================-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


        <script type="text/javascript">

    

        </script>
    </body>
</html>
