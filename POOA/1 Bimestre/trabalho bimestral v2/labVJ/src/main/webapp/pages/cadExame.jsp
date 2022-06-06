
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card" >

    <h1>Cadastro de um novo exame</h1>

</div>
<div class="card" >

    <form action="control" method="POST" style="width: 100%">
        
        <c:if test="${requestScope.exame == null}">
                 <input type="hidden" name="ac" value="saveExame"> <!-- parâmetro que indica ao 'control' o que fazer -->
        </c:if>
                 
        <c:if test="${requestScope.exame != null}">
                 <input type="hidden" name="ac" value="saveEditedExame"> <!-- parâmetro que indica ao 'control' o que fazer -->
                 <input type="hidden" name="id" value="${requestScope.exame.id}"> <!-- parâmetro que indica ao 'control' o que fazer -->
        </c:if>
        
        
      <fieldset class="grupo" >
            <div class="campo" style="width: 100%">
                <label for="desc">Descrição</label>
                <textarea id="cpDesc" name="cpDesc" style="width: 100%" required="">${requestScope.exame.descricao}</textarea>
            </div>
        </fieldset> 
        <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="dataPl">Data Planejada</label>
                <input type="Date" id="cpDataPl" name="cpDataPl" style="width: 100%" value="${requestScope.exame.dataPlanejadaString}" required="">
            </div>
        </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpCusto">Custo</label>
                <input type="text" id="cpCusto" name="cpCusto" style="width: 100%" value="${requestScope.exame.custo}" required="">
            </div>
      </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpJejum">Tempo de jejum (em horas)</label>
                <input type="text" id="cpJejum" name="cpJejum" style="width: 100%" value="${requestScope.exame.tempoJejum}" required="">
            </div>
      </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpUser">CPF do usuário</label>
                <input type="number" id="cpUser" name="cpUser" style="width: 100%" value="${requestScope.exame.usuario}" required="">
            </div>
      </fieldset> 
        <button class="botao submit" type="submit" name="submit">Gravar</button> <br /> 
        
                <span style="color: red">${requestScope.msg}</span>
        
    </form>


</div>
