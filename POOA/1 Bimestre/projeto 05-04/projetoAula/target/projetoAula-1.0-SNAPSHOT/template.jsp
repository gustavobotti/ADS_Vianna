<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" 
              integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" 
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <header>
                <div>
                    <img src="img/logo.svg" alt="logo bolo">
                </div>
                <div class="title">
                    niverSite
                </div>
                <div class="info">
                    <i class="fa-solid fa-circle-question"></i>
                </div>
            </header>
            <main class="cartao">
                
                <c:if test="${param.pg == null}">
                    <jsp:include page="login.jsp" />
                </c:if>
                
                <c:if test="${param.pg != null}">
                    <jsp:include page="${param.pg}.jsp" />
                </c:if>
      
            </main>
            <footer class="footer">
                <ul>
                    <li>
                        <i class="fa-solid fa-bars"></i> 
                    </li>
                    <li>
                        <i class="fa-solid fa-magnifying-glass"></i> 
                    </li>
                    <li>
                        <i class="fa-solid fa-bell"></i> 
                    </li>
                </ul>
                <div class="btnFloating">
                    <i class="fa-solid fa-plus"></i>
                </div>
            </footer>
        </div>
    </body>
</html>
