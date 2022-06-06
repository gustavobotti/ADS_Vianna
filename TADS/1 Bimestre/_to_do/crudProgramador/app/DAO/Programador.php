<?php
namespace app\DAO;

use app\Conexao;

class Programador{
    private $nome;
    private $email;
    private $endereco;
    private $profissao;
    private $genero;
    private $area;
    private $recado;
    private $promocoes;
    private $senha;

    public static function novo($nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha){
        $db = Conexao::conecta();
        $sql = "INSERT INTO `tads`.`programador` (`nome`, `email`, `endereco`, `profissao`, `genero`, `area`, `recado`, `promocoes`, `senha`) 
        VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?');";

        $stmt = $db->prepare($sql);
        $stmt->bind_param('sssssssss',$nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        return true;
    }
    
    public static function exibeProgramadores()
    {
        $db = Conexao::conecta();
        $sql = "SELECT * FROM `tads`.`programador`";
        
        if (!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        echo "<table border=1>";
            echo "<tr> 
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Endereço</th>
                    <th>Profissão</th>
                    <th>Gênero</th>
                    <th>Áreas de Interesse</th>
                    <th>Fale Conosco</th>
                    <th>Aceita promoções?</th>
                    <th>Senha</th>
                    <th>Excluir</th>
                    <th>Alterar</th>
                </tr>";
            while ($programador = $result->fetch_object('app\DAO\Programador')) {
                echo "<tr>";
                    echo "<td>".$programador->retornaCampo('nome')."</td>";
                    echo "<td>".$programador->retornaCampo('email')."</td>";
                    echo "<td>".$programador->retornaCampo('endereco')."</td>";
                    echo "<td>".$programador->retornaCampo('profissao')."</td>";
                    echo "<td>".$programador->retornaCampo('genero')."</td>";
                    echo "<td>".$programador->retornaCampo('area')."</td>";
                    echo "<td>".$programador->retornaCampo('recado')."</td>";
                    echo "<td>".$programador->retornaCampo('promocoes')."</td>";
                    echo "<td>".$programador->retornaCampo('senha')."</td>";
                    echo "<td><a href=\"index.php?excluir=".$programador->retornaCampo('id')."\">X</a></td>";
                    echo "<td><a href=\"index.php?alterar=".$programador->retornaCampo('id')."\">X</a></td>";
                echo "</tr>";
            }
        echo "</table>";
    }

    public static function excluir($id)
    {
        $db = Conexao::conecta();
        $sql = "DELETE FROM `tads`.`programador` WHERE  `id`=?;";

        $stmt = $db->prepare($sql);
        $stmt->bind_param('i',$id);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        return true; 
    }
    public function retornaCampo($campo)
    {
        if (isset($this->$campo)){
            return $this->$campo;
        }
    }
    

    public static function retornaProgramador($id)
    {
        $db = Conexao::conecta();
        $sql = "SELECT * FROM `tads`.`programador` WHERE `programador`.`id`=?";
        
        $stmt = $db->prepare($sql);
        $stmt->bind_param('i',$id);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        if ($recado = $result->fetch_object('app\DAO\Programador')){
            return $recado;
        }else{
            return false;
        }
    }

    public static function atualiza($id,$nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha){
        $db = Conexao::conecta();
        $sql = "UPDATE `tads`.`programador` SET `nome`='$nome', `email`='$email', `endereco`='$endereco', `profissao`='$profissao', `genero`='$genero', `area`='$area', `recado`='$recado', `promocoes`='$promocoes', `senha`='$senha' WHERE  `id`=$id";
        
        $stmt = $db->prepare($sql);
        $stmt->bind_param('sssssssssi',$nome,$email,$endereco,$profissao,$genero,$area,$recado,$promocoes,$senha,$id);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        return true;
    }

}