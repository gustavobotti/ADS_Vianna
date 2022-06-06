<!DOCTYPE html>
<html>
<body>

<?php
$nome = $_POST["nome"];
$email = $_POST["email"];
$sugestao = $_POST["sugestao"];
$mensagem = "Sugestao enviada por visitante: \n\n";
$mensagem .= "Nome: $nome\n";
$mensagem .= "E-mail: $email\n";
$mensagem .= "Sugestão: $sugestao";
mail("webmaster@umsite.com.br", "Sugestao", $mensagem); 
echo Obrigado por enviar sua sugestão!";
?>

</body>
</html>
