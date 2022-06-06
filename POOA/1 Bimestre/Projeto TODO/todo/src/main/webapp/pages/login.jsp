
<div class="card" style="margin-top: 150px">
    <div>
        <span class="cardTitle">LOGIN</span>
        <span class="formCard" id="frmSoma">
            <form action="control" method="POST">                
                <input type="hidden" name="ac" value="verifyLogin" />
                Login <input type="text" name="cpLogin" />
                <br/>
                Senha <input type="password" name="cpSenha" />
                <br/>
                <button type="submit">Logar</button>
                <br/>
                <span style="color: red">${requestScope.msg}</span>
            </form>
        </span>

    </div>
    <div>
        <img src="img/niver.svg" />
    </div>
</div>
