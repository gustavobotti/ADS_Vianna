<?php
    $nome = $_POST["nome"];
    $email = $_POST["email"];
    $sugestao = $_POST["sugestao"];
    $mensagem = "Sugestão enviado por um visitante:\n\n";
    $mensagem .= "Nome: $nome\n";
    $mensagem .= "Email: $email\n";
    $mensagem .= "Sugestão $sugestao\n";
    mail("webmaster@umsite.com.br", "Sugestao", $mensagem);
    echo "Obrigado por enviar sua sugestão!";
?>

/mostrar pro gildo

<?php
    $nome = $_POST["nome"];
    $email = $_POST["email"];
    $sugestao = $_POST["sugestao"];
    $mensagem = "Sugestão enviado por um visitante:\n\n";
    $mensagem .= "Nome: $nome\n";
    $mensagem .= "Email: $email\n";
    $mensagem .= "Sugestão $sugestao\n";
    echo $mensagem;
    echo "Obrigado por enviar sua sugestão!";
?>