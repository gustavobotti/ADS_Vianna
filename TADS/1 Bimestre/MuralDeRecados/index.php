<?php
require_once "app\Conexao.php";
require_once "app\DAO\Recado.php";

use app\DAO\Recado;

if(isset($_POST['acao'])){
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $cidade = $_POST['cidade'];
    $recado = $_POST['recado'];

    if (Recado::novo($nome,$email,$cidade,$recado)){
        echo "Recado cadastrado! ";
    }
}

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="nome">Nome: </label>
        <input type="text" name="nome" id="nome"><br>
        <label for="email">Email: </label>
        <input type="text" name="email" id="email"><br>
        <label for="cidade">Cidade: </label>
        <input type="text" name="cidade" id="cidade"><br>
        <label for="recado">Recado: </label>
        <textarea type="text" name="recado" id="recado" cols="30" rows="10"></textarea><br>
        <input type="submit" value="Cadastrar" name="acao"><br>
    </form>
</body>
</html>