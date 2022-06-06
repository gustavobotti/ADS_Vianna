
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card" >

    <form action="control" method="POST" style="width: 100%">
        
        <c:if test="${requestScope.task == null}">
                 <input type="hidden" name="ac" value="saveTask"> <!-- parâmetro que indica ao 'control' o que fazer -->
        </c:if>
                 
        <c:if test="${requestScope.task != null}">
                 <input type="hidden" name="ac" value="saveEditedTask"> <!-- parâmetro que indica ao 'control' o que fazer -->
                 <input type="hidden" name="id" value="${requestScope.task.id}"> <!-- parâmetro que indica ao 'control' o que fazer -->
        </c:if>
        
        
      <fieldset class="grupo" >
            <div class="campo" style="width: 100%">
                <label for="desc">Descrição</label>
                <textarea id="cpDesc" name="cpDesc" style="width: 100%" required="">${requestScope.task.descricao}</textarea>
            </div>
        </fieldset> 
        <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="dataPl">Data Planejada</label>
                <input type="Date" id="cpDataPl" name="cpDataPl" style="width: 100%" value="${requestScope.task.dataPlanejadaString}" required="">
            </div>
        </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cate">Categoria</label>
                <select id="cpCate" name="cpCate" style="width:100%">
                    <c:forEach items="${requestScope.categorias}" var="c">
                        <c:if test="${c.id != null}">
                             <option value="${c.id}">${c.nome}</option>                            
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </fieldset>
        <button class="botao submit" type="submit" name="submit">Gravar</button> <br /> 
        
                <span style="color: red">${requestScope.msg}</span>
        
    </form>


</div>
