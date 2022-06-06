
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="br.vianna.aula.matadorweb.model.Time"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Listagem de Times</h1>
 
 <table class="table table-striped">
   
     <fieldset>
         <legend>Pesquisar</legend>
         <form action="control" method="POST" > 
             <input type="hidden" name="ac" value="listaTimes" />
            
             <div class="row">
                 <div class="col">                  
                        <div class="form-group">                 
                           <label for="time">Nome do Time:</label> 
                           <input type="text" name="cpSearchNome" class="form-control"
                                  placeholder="nome do time"/>  

                        </div>
                            
                     <c:if test="${sessionScope.user.ehAdm == 'SIM'}">                         
                        <div class="form-group">                 
                           <label for="time">Usuários:</label> 
                           <select name="cpSearchUser" class="form-control">  
                               <option value="-1">Todos Usuários</option>
                               
                               <c:forEach items="${requestScope.usuarios}" var="u">
                                   <option value="${u.idusuario}">${u.nome}</option>                                   
                               </c:forEach>                               
                               
                           </select>

                        </div>
                     </c:if>
                 </div>
                 
                 
                 <div class="col"> 
                 
                        <div class="form-group">                 
                           <label for="time">Data Fundação:</label> 
                           De: <input type="date" name="cpdata1" class="form-control"/>  
                           até <input type="date" name="cpdata2" class="form-control"/>  

                        </div>
                 </div>
             </div>
             
         
             <div class="form-group">               
             <button type="submit" class="btn btn-primary" >Pesquisar</button>
             </div>
         
             
             
         </form>
         
     </fieldset>
     
     <thead>
         <tr>
             <th>Nome Time</th>
             <th>Data Fundação</th>
             <th>Ação</th>
         </tr>
     </thead>
     <tbody>
         
         <c:if test="${requestScope.times.size() == 0}">
            <tr>
                <td class="text-center" colspan="3"> Não há Times Cadastrados</td>
            </tr> 
         </c:if>
         
         <c:forEach var="t" items="${requestScope.times}">
             
            <tr>
                <td>${t.nome}</td>
                <td> <fmt:formatDate value="${t.dataFundacao}" pattern="dd/MM/yyyy" /> </td>
                <td>
                    <a href="control?ac=editTime&id=${t.idtime}"><span><i class="fa fa-edit"></i></span></a>
                     
                    <i class="fa fa-trash"></i>
                    
                </td>
            </tr>
             
         </c:forEach>          
            
<!--         <tr>
             <td>São Paulo</td>
             <td>10/10/2020</td>
             <td>A X</td>
         </tr>-->
     </tbody>
     
     
 </table>
 
                 
 
 