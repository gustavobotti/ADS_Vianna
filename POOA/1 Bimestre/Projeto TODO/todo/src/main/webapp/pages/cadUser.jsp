
<div class="card" >

    <form action="control" method="POST" style="width: 100%">
        
        <input type="hidden" name="ac" value="saveUser"> <!-- parâmetro que indica ao 'control' o que fazer -->
        
      <fieldset class="grupo" >
            <div class="campo" style="width: 100%">
                <label for="nome">Nome</label>
                <input type="text" id="cpNome" name="cpNome" style="width: 100%" value="${requestScope.user.nome}" required="">
            </div>
        </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Email</label>
                <input type="text" id="cpEmail" name="cpEmail" style="width: 100%" value="${requestScope.user.email}" required="">
            </div>
        </fieldset> 
        <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Login</label>
                <input type="text" id="cpLogin" name="cpLogin" style="width: 100%" value="${requestScope.user.login}" required="" minlength="4">
            </div>
        </fieldset> 
        <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Senha</label>
                <input type="text" id="cpSenha" name="cpSenha" style="width: 100%" value="" required="">
            </div>
        </fieldset> 
        <button class="botao submit" type="submit" name="submit">Gravar</button> <br /> 
        
                <span style="color: red">${requestScope.msg}</span>
        
    </form>


</div>
