
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card" >

    <h1>Dando baixa num exame</h1>

</div>
<div class="card" >

    <form action="control" method="POST" style="width: 100%">
        
        <input type="hidden" name="ac" value="endExame"> <!-- parâmetro que indica ao 'control' o que fazer -->
               
      
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpCodigo">Código do exame</label>
                <input type="text" id="cpCodigo" name="cpCodigo" style="width: 100%" value="${requestScope.exame.id}" required="">
            </div>
      </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="cpUser">CPF do usuário</label>
                <input type="number" id="cpUser" name="cpUser" style="width: 100%" value="${requestScope.exame.usuario}" required="">
            </div>
      </fieldset> 
        <button class="botao submit" type="submit" name="submit">Finalizar</button> <br />    
        
                <span style="color: red">${requestScope.msg}</span>        
                
    </form>
</div>
