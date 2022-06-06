<!DOCTYPE html>
<html lang="en">

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
            <option value="MG">Minas Gerais</option>
            <option value="RJ">Rio de Janeiro</option>
            <option value="ES">Espirito Santo</option>
        </select>
        <br>
        <label for="extra">Na sua casa tem:</label>
        <input type="checkbox" name="extras[]" value="Garagem">Garagem
        <input type="checkbox" name="extras[]" value="Piscina">Piscina
        <input type="checkbox" name="extras[]" value="Jardim">Jardim
        <input type="submit" name="Enviar">
    </form>
    <?php
        if(isset($_POST['nome'])? "o nome digitado foi {$_POST['nome']} <br>":"Não foi informado o nome");    
      
        if(isset($_POST['optCivil'])){
            echo "e o estado civil é {$_POST['optCivil']} <br>";
        }
        if(isset($_POST['estado'])){
            echo "o estado é {$_POST['estado']}<br>";
        }
        if(isset($_POST['extras'])){
            echo "na casa tem: ";
            foreach($_POST['extras'] as $extra){
            echo "$extra ";
            }
        }
    ?>
</body>

</html>