
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
                <label for="snome">Telefone</label>
                <input type="text" id="cpTelefone" name="cpTelefone" style="width: 100%" value="${requestScope.user.telefone}" required="">
            </div>
      </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Endereco</label>
                <input type="text" id="cpEndereco" name="cpEndereco" style="width: 100%" value="${requestScope.user.endereco}" required="">
            </div>
     </fieldset> 
    <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">CPF</label>
                <input type="number" id="cpCPF" name="cpCPF" style="width: 100%" value="${requestScope.user.cpf}" required="">
            </div>
     </fieldset> 
      <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Sexo</label>
                <select id="cpSexo" name="cpSexo" style="width:100%">
                    <option value="Masculino">Masculino</option>
                    <option value="Feminino">Feminino</option>
                    <option value="Outro">Outro</option>
                </select>
            </div>
     </fieldset> 
     <fieldset class="grupo">
            <div class="campo" style="width: 100%">
                <label for="snome">Plano de Saúde</label>
                <select id="cpPlano" name="cpPlano" style="width:100%">
                    <option value="Nenhum">Nenhum</option>
                    <option value="UniSaude">UniSaude</option>
                    <option value="PlanMed">PlanMed</option>
                    <option value="SaudeMais">SaudeMais</option>
                </select>
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
