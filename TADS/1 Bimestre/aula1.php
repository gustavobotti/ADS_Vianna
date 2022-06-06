<?php
    $nome = "João";
    $aluno = $nome;
    $nome = "Silva";
    echo("<p> Nome $nome <br> Aluno $aluno </p> \n"); //passando por valor

    $Nome = "João";
    $Aluno = &$Nome; // utilizar & para passar por referencia
    $Nome = "Silva";
    echo("<p> Nome $Nome <br> Aluno $Aluno </p> \n"); //passando por referencia

    echo("<p>".'Nome: $nome'."<br>");
    echo("\n Nome: ".$nome."<br>");
    echo("\n \n \n </p>");

    echo gettype($nome); // pega o tipo

    $total = "10.3"; // automaticamente detecta que o integer virou double
    echo "<br><p> Total: $total</p>";


    $a = "10";
    if(is_integer($a)){ // teste if/else
        echo "Inteiro";
    }elseif(is_string($a)){
        echo "String<br>";
    }


    $b = "20";
    switch ($b){ // teste switch
        case "10":
            echo "<br>O valor é 10";
            break;
        case "9":
            echo "<br>O valor é 9";
            break;
        default:
            echo "<br>Não é nenhum valor";
            break;
    }


    $c = "30";
    for($c = 0; $c < 30; $c++){ //inicialização; condição; atualização;
        echo $c.'<br>';
    }
?>