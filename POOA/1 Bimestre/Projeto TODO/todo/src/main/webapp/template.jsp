<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="board">

            <div class="header" >

                <img src="/img/logo.svg" alt="logo" />

                <h1 class="title">TODO :: Lista de Tarefas</h1>


                <div class="tap">
                    <label class="switch">
                        <input type="checkbox"  />
                        <span class="slider round"></span>
                    </label>
                </div>

            </div>

            <div class="main">

                <div class="cards">

                    <c:if test="${param.pg == null}">
                        <jsp:include page="pages/home.jsp" />
                    </c:if>
                    <c:if test="${param.pg != null}">
                        <jsp:include page="pages/${param.pg}.jsp" /> 
                    </c:if>                       

                </div>
                <span style="color: white; padding-left: 10px">${requestScope.msgAviso}</span>

            </div>



            <div class="footer">

                <ul>
                    <c:if test="${sessionScope.user == null}">    
                        
                    <li class="list">
                        <a href="control">  
                            <span class="icon">
                                <i class="fa-solid fa-bars"></i>
                            </span>
                        </a>
                    </li>
                        <li class="list">
                            <a href="control?ac=create">                            
                                <span class="icon">
                                    <i class="fa-solid fa-user"></i>
                                </span>
                            </a>
                        </li>
                        <li class="list">
                            <a href="control?ac=login">                            
                                <span class="icon">
                                    <i class="fa-solid fa-sign-in"></i>
                                </span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">  
                        
                    <li class="list">
                        <a href="control?ac=logado">  
                            <span class="icon">
                                <i class="fa-solid fa-bars"></i>
                            </span>
                        </a>
                    </li>
                        <li class="list">
                            <a href="control?ac=cate">                            
                                <span class="icon">
                                    <i class="fa-solid fa-address-card"></i>
                                </span>
                            </a>
                        </li> 
                        <li class="list">
                            <a href="control?ac=task">                            
                                <span class="icon">
                                    <i class="fa-solid fa-dashboard"></i>
                                </span>
                            </a>
                        </li>
                        <li class="list">
                            <a href="control?ac=logout">                            
                                <span class="icon">
                                    <i class="fa-solid fa-sign-out"></i>
                                </span>
                            </a>
                        </li>
                    </c:if>
                    <!--                    <li class="list">
                                            <span class="icon">                        
                                                <i class="fa-solid fa-bell"></i>
                                            </span>
                                        </li>-->
                </ul>


                <div class="iconFab" >
                    <i class="fa-solid fa-plus"></i>

                </div>

            </div>

        </div>


        <script src="js/dark.js" type="text/javascript"></script>


    </body>
</html>
