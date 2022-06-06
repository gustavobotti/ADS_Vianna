<?php
    echo "Escreva um loop que imprima o quadrado de 1 até 20 da seguinte forma: O quadrado de 1 é 1. <br>";

    $a = 1;
    for($a = 1; $a <= 20; $a++){ //inicialização; condição; atualização;
        echo "<br>O quadrado de ".$a." é ".pow($a, 2);
    }
?>