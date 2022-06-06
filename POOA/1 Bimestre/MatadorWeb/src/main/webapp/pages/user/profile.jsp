
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>
    Profile ${sessionScope.user.nome} (${sessionScope.user.tipoPermissao()})
</h1>

    <c:if test="${requestScope.msgError != null}">
    
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${requestScope.msgError}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        
</c:if>

    <c:if test="${requestScope.msgSuccess != null}">
    
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${requestScope.msgSuccess}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        
</c:if>

<form action="control?ac=saveProfile" method="POST">
    <div class="mb-3">
        <label for="nomeTime" class="form-label">Nome do usuário</label>
        <input required type="text" class="form-control" id="nomeTime" name="cpNomeUser"
               
               value="${sessionScope.user.nome}"   >
    </div>
    <div class="mb-3 has-validation">
        <label for="nomeTime" class="form-label">Login do usuário</label>
        <input required type="text" class="form-control" id="cpLogin" name="cpLoginUser"
               value="${sessionScope.user.login}"   >
        
        <div class="invalid-feedback">
            login já existe!!!
        </div>
        
    </div>
    
    <fieldset>
        <legend>Senhas</legend>
        <div class="mb-3">
        <label for="nomeTime" class="form-label">senha</label>
        <input required type="password" class="form-control" id="nomeTime" name="cpSenhaUser"
               value=""   >
    </div>
    <div class="mb-3">
        <label for="nomeTime" class="form-label">repita a senha</label>
        <input required type="password" class="form-control" id="nomeTime" name="cpRepSenhaUser"
               value=""   >
    </div>
    </fieldset>
    
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Alterar</button>
    </div>
</form>
               
               <script>
                   
                   $("#cpLogin").on("keyup",function() {
                       console.log("mudou") ;
                    });
                   
               </script>               

