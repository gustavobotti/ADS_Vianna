<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>
</head>
<body>
    <?php var_dump($_POST) ?>
    <form action="" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome"><br>
        <label for="optCivil">Estado Civil:</label>
        <input type="radio" name="optCivil" value="Solteiro(a)">Solteiro(a)
        <input type="radio" name="optCivil" value="Casado(a)">Casado(a)
        <br>
        <label for="estado">Estado:</label>
        <select name="estado">
            <option value="ES">Espirito Santo</option>
            <option value="MG">Minas Gerais</option>
            <option value="RJ">Rio de Janeiro</option>
        </select><br>
        <label for="extra">Na sua casa têm: </label>
        <input type="checkbox" name="extras[]" value="Garagem"> Garagem 
        <input type="checkbox" name="extras[]" value="Piscina"> Piscina 
        <input type="checkbox" name="extras[]" value="Jardim"> Jardim <br> 
        <input type="hidden" name="id" value="132">

        <input type="submit" value="Enviar">
    </form>
    <?php
    if (isset($_POST['nome']) && !empty($_POST['nome'])){
        echo "O nome digitado foi {$_POST['nome']} <br>";
    }
    if (isset($_POST['optCivil'])){
        echo "O estado civil é {$_POST['optCivil']} <br>";
    }
    if (isset($_POST['estado'])){
        echo "O estado é {$_POST['estado']} <br>";
    }
    if (isset($_POST['extras'])){
        echo "Na casa têm: ";
        foreach ($_POST['extras'] as $extra){
            echo "$extra -";
        }
    }
    
    $a = 10;
    $b = 20;
    echo maiorValor($a,$b);

    function maiorValor($var1, $var2){
        if($var1 > $var2){
            $var1 = 0;
            $var2 = 0;
            return $var1;
        }else if($var2 > $var1){
            $var1 = 0;
            $var2 = 0;
            return $var2;
        }else{
            $var1 = 0;
            $var2 = 0;
            return false;
        }
    }

    var_dump($a,$b);


    ?>
</body>
</html>