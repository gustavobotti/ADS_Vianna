

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${requestScope.titulo}</h1>


<c:if test="${requestScope.msg != null}">
    
<div class="alert alert-success">
    ${requestScope.msg}
</div>
    
</c:if>

<%--
<c:set var="acao" value="control?ac=timeCad" />
<c:if test="${requestScope.time.idtime > 0}">
   <c:set var="acao" value="control?ac=timeEdit" /> 
</c:if>

--%>


<form action="control?ac=timeCad" method="POST">
    <input type="hidden" name="cpId" value="${requestScope.time.idtime}" />
    <div class="mb-3">
        <label for="nomeTime" class="form-label">Nome do Time</label>
        <input required type="text" class="form-control" id="nomeTime" name="cpNomeTime"
               value="${requestScope.time.nome}"   >
    </div>
    <div class="mb-3">
        <label for="dataTime" class="form-label">Data de Fundao</label>
        <input required="" type="date" class="form-control" id="dataTime" name="cpFundacao"
             value="${requestScope.time.dataAmericana()}"  >
    </div>
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
</form>

