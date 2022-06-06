<?php
require_once "app\Conexao.php";
require_once "app\DAO\Programador.php";

use app\DAO\Programador;

if (isset($_POST['acao']) && ($_POST['acao']=='Cadastrar') ){
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $cidade = $_POST['cidade'];
    $recado = $_POST['recado'];

    if (Programador::novo($nome,$email,$cidade,$recado)){
        echo 'Programador cadastrado!';
    }
}else if(isset($_GET['excluir']))
{
    $id = $_GET['excluir'];
    if(Programador::excluir($id)){
        echo 'Programador apagado!';
    }
}else if(isset($_GET['alterar'])){
    $id = $_GET['alterar'];
    $recado = Programador::retornaProgramador($id);
    $nome = $recado->retornaCampo('nome');
    $email = $recado->retornaCampo('email');
    $cidade = $recado->retornaCampo('cidade');
    $mensagem = $recado->retornaCampo('recado');
}else if(isset($_GET['atualiza'])){
    $id = $_GET['atualiza'];
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $cidade = $_POST['cidade'];
    $recado = $_POST['recado'];
    if (Programador::atualiza($id,$nome,$email,$cidade,$recado)){
        echo 'Programador Alterado!';
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
            <option value="<?= $profissao??'' ?>">Engenheiro de Software</option>
            <option value="<?= $profissao??'' ?>">Analista de Segurança de Informação</option>
            <option value="<?= $profissao??'' ?>">Analista de Sistemas</option>
            <option value="<?= $profissao??'' ?>">Administrador de Sistemas</option>
            <option value="<?= $profissao??'' ?>">Administrador do banco de dados (DBA)</option>
            <option value="<?= $profissao??'' ?>">Gestor de tecnologias da informação</option>
            <option value="<?= $profissao??'' ?>">Arquiteto de redes</option>
            <option value="<?= $profissao??'' ?>">Desenvolvedor</option>
        </select>

        <label for="genero">Gênero: </label>
        <select name="genero">
            <option value="<?= $genero??'' ?>">Masculino</option>
            <option value="<?= $genero??'' ?>">Feminino</option>
            <option value="<?= $genero??'' ?>">Prefiro não informar</option>
            <option value="<?= $genero??'' ?>">Outro. (Qual?)</option>
        </select>

        <label for="profissao">Áreas de interesse: </label>
        <select></select><!-- pode escolher mais de uma -->

        <label for="recado">Fale Conosco:</label><br>
        <textarea name="recado" id="recado" cols="30" rows="10"><?= $mensagem??'' ?></textarea><br>

        <label for="promocoes">Deseja receber promoções? </label>
        <input type="checkbox" name="promocoes" id="promocoes" value="<?= $promocoes??'' ?>"><br>

        <label for="senha">Senha: </label>
        <input type="password" name="senha" id="senha" value="<?= $senha??'' ?>"><br>

        <label for="confirmaSenha">Confirmação da senha: </label>
        <input type="password" name="confirmaSenha" id="confirmaSenha" value="<?= $senha??'' ?>"><br>
        
        <input type="submit" value="<?= isset($id)?'Atualizar':'Cadastrar' ?>" name="acao">
    </form>
<?php
    Programador::exibeProgramadores();
?>
</body>
</html>