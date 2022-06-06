<html>
<body>
<?php
    $nome = $_POST["nome"];
    echo "Nome: $nome";
?><br>
<?php
    $email = $_POST["email"];
    echo "Email: $email";
?><br>
<?php
    $endereco = $_POST["endereco"];
    echo "Endereco: $endereco";
?><br>
<?php   
    if (isset($_POST['profissao'])){
        echo "Profissao: {$_POST['profissao']}";
    }
?><br>
<?php
    $genero = $_POST["genero"];
    $outroql = $_POST["outroql"];
    if ($genero == 'Outro: '){
        echo "Genero: $genero" . $outroql;
    } else {
        echo "Genero: $genero";
    }
?><br>As areas de interesse selecionadas foram:
<?php
    $areasInteresse = $_POST['areasInteresse'];
    
    foreach($areasInteresse as $areaInteresse){
    print ($areaInteresse . " ");
    }
?><br>
<?php
    $faleConosco = $_POST["faleConosco"];
    echo "Fale conosco: $faleConosco";
?><br>
<?php
    $promocoes = $_POST["promocoes"];
    echo "Quer receber promocoes: $promocoes";
?><br>
<?php
    $senha = $_POST["senha"];
    echo "Senha: $senha";
?><br>
<?php
    $senha2 = $_POST["senha2"];
    echo "Confirmacao de senha: $senha2";
?><br>
</body>
</html>