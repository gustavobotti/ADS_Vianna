<?php
require_once "app\Conexao.php";
require_once "app\DAO\Programador.php";

use app\DAO\Programador;

if (isset($_POST['acao']) && ($_POST['acao']=='Cadastrar') ){
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $endereco = $_POST['endereco'];
    $profissao = $_POST['profissao'];
    $genero = $_POST['genero'];
    if (isset($_POST['area'])){        
        $area = " Banco de dados";        
    } 
    if (isset($_POST['area2'])){        
        $area = $area." Engenharia de software";        
    }
    if (isset($_POST['area3'])){        
        $area = $area." Redes de computadores"; 
    }
    if (isset($_POST['area4'])){        
        $area = $area." Desenvolvimento de jogos"; 
    }
    if (isset($_POST['area5'])){        
        $area = $area." Programação back-end"; 
    }
    if (isset($_POST['area6'])){        
        $area = $area." Programação front-end"; 
    }
    if (isset($_POST['area7'])){        
        $area = $area." Mineração de dados"; 
    } 
    if (!isset($area)){        
        $area = 'Nenhuma';        
    } 
    $recado = $_POST['recado'];
    if (isset($_POST['promocoes'])){        
        $promocoes = "Sim";
    }
    if (!isset($promocoes)) {
        $promocoes = "Não";
    }
    $senha = $_POST['senha'];
    $confirmaSenha = $_POST['confirmaSenha'];

    if ($senha == $confirmaSenha){
        if (Programador::novo($nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha)){
            echo 'Programador cadastrado!';
        }
    } else {
        echo 'Senha diferente!';
    }
}else if(isset($_GET['excluir']))
{
    $id = $_GET['excluir'];
    if(Programador::excluir($id)){
        echo 'Programador apagado!';
    }
}else if(isset($_GET['alterar'])){
    $id = $_GET['alterar'];
    $programador = Programador::retornaProgramador($id);
    $nome = $programador->retornaCampo('nome');
    $email = $programador->retornaCampo('email');
    $endereco = $programador->retornaCampo('endereco');
    $recado = $programador->retornaCampo('recado');
    $senha = $programador->retornaCampo('senha');
}else if(isset($_GET['atualiza'])){
    $id = $_GET['atualiza'];
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $endereco = $_POST['endereco'];
    $profissao = $_POST['profissao'];
    $genero = $_POST['genero'];
    
    if (!isset($area)){        
        $area = '';        
    } 
    if (isset($_POST['area'])){        
        $area = " Banco de dados";        
    } 
    if (isset($_POST['area2'])){        
        $area = $area." Engenharia de software";        
    }
    if (isset($_POST['area3'])){        
        $area = $area." Redes de computadores"; 
    }
    if (isset($_POST['area4'])){        
        $area = $area." Desenvolvimento de jogos"; 
    }
    if (isset($_POST['area5'])){        
        $area = $area." Programação back-end"; 
    }
    if (isset($_POST['area6'])){        
        $area = $area." Programação front-end"; 
    }
    if (isset($_POST['area7'])){        
        $area = $area." Mineração de dados"; 
    } 
    if (!isset($area)){        
        $area = 'Nenhuma';        
    } 
    $recado = $_POST['recado'];
    if (isset($_POST['promocoes'])){        
        $promocoes = "Sim";
    }
    if (!isset($promocoes)) {
        $promocoes = "Não";
    }
    $senha = $_POST['senha'];
    if (Programador::atualiza($id,$nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha)){
        echo 'Programador alterado!';
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Programador</title>
</head>
<body>
    <form action="<?= isset($id)?'index.php?atualiza='.$id:'index.php' ?> " method="post">
        <label for="nome">Nome: </label>
        <input type="text" name="nome" id="nome" value="<?= $nome??'' ?>"><br>

        <label for="email">Email: </label>
        <input type="email" name="email" id="email" value="<?= $email??'' ?>"><br>

        <label for="endereco">Endereço: </label>        
        <input type="text" name="endereco" id="endereco" value="<?= $endereco??'' ?>"><br>

        <label for="profissao">Profissão: </label>
        <select name="profissao">
            <option value="Desempregado">Desempregado</option>
            <option value="Engenheiro de Software">Engenheiro de Software</option>
            <option value="Analista de Segurança">Analista de Segurança de Informação</option>
            <option value="Analista de Sistemas">Analista de Sistemas</option>
            <option value="Administrador de Sistemas">Administrador de Sistemas</option>
            <option value="Administrador do banco de dados (DBA)">Administrador do banco de dados (DBA)</option>
            <option value="Gestor de tecnologias da informação">Gestor de tecnologias da informação</option>
            <option value="Arquiteto de redes">Arquiteto de redes</option>
            <option value="Desenvolvedor">Desenvolvedor</option>
        </select><br>

        <label for="genero">Gênero: </label>
        <select name="genero">
            <option value="Masculino">Masculino</option>
            <option value="Feminino>">Feminino</option>
            <option value="Prefiro não informar">Prefiro não informar</option>
            <option value="Outro">Outro (Qual?)</option>
        </select>
        <label for="outroQl">Caso outro, favor informe qual: </label>        
        <input type="text" name="outroQl" id="outroQl" value="<?= ''??'' ?>">
        <br>

        <span>Áreas de interesse: </span>     <br>   
        <input type="checkbox" id="area" name="area" value=" Banco de dados"><label for="area">Banco de dados</label><br>
        <input type="checkbox" id="area2" name="area2" value=" Engenharia de software"><label for="area2">Engenharia de software</label><br>
        <input type="checkbox" id="area3" name="area3" value=" Redes de computadores"><label for="area3">Redes de computadores</label><br>
        <input type="checkbox" id="area4" name="area4" value=" Desenvolvimento de jogos"><label for="area4">Desenvolvimento de jogos</label><br>
        <input type="checkbox" id="area5" name="area5" value=" Programação back-end"><label for="area5">Programação back-end</label><br>
        <input type="checkbox" id="area6" name="area6" value=" Programação front-end"><label for="area6">Programação front-end</label><br>
        <input type="checkbox" id="area7" name="area7" value=" Mineração de dados"><label for="area7">Mineração de dados</label><br>

        <label for="recado">Fale Conosco:</label><br>
        <textarea name="recado" id="recado" cols="30" rows="10"><?= $mensagem??'' ?></textarea><br>

        <label for="promocoes">Deseja receber promoções? </label>
        <input type="checkbox" id="promocoes" name="promocoes" value="<?= $promocoes??'' ?>"><br>

        <label for="senha">Senha: </label>
        <input type="password" name="senha" id="senha" value="<?= $senha??'' ?>"><br>

        <label for="confirmaSenha">Confirmação da senha: </label>
        <input type="password" name="confirmaSenha" id="confirmaSenha" value="<?= $confirmaSenha??'' ?>"><br>
        
        <input type="submit" value="<?= isset($id)?'Atualizar':'Cadastrar' ?>" name="acao">
    </form>
<?php
    Programador::exibeProgramadores();
?>
</body>
</html>