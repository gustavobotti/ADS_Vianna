<?php
namespace app\DAO;

use app\Conexao;

class Programador{
    private $nome;
    private $email;
    private $cidade;
    private $recado;

    public static function novo($nome,$email,$cidade,$recado){
        $db = Conexao::conecta();
        $sql = "INSERT INTO `tads`.`recado` (`nome`, `email`, `cidade`, `recado`) VALUES ('$nome', '$email', '$cidade', '$recado');";
        if (!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        return true;
    }
    
    public static function exibeProgramadores()
    {
        $db = Conexao::conecta();
        $sql = "SELECT * FROM `tads`.`recado`";
        if (!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        echo "<table border=1>";
            echo "<tr> 
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Cidade</th>
                    <th>Programador</th>
                    <th>Excluir</th>
                    <th>Alterar</th>
                </tr>";
            while ($recado = $result->fetch_object('app\DAO\Programador')) {
                echo "<tr>";
                    echo "<td>".$recado->retornaCampo('nome')."</td>";
                    echo "<td>".$recado->retornaCampo('email')."</td>";
                    echo "<td>".$recado->retornaCampo('cidade')."</td>";
                    echo "<td>".$recado->retornaCampo('recado')."</td>";
                    echo "<td><a href=\"index.php?excluir=".$recado->retornaCampo('id')."\">X</a></td>";
                    echo "<td><a href=\"index.php?alterar=".$recado->retornaCampo('id')."\">X</a></td>";
                echo "</tr>";
            }
        echo "</table>";
    }

    public static function excluir($id)
    {
        $db = Conexao::conecta();
        $sql = "DELETE FROM `tads`.`recado` WHERE  `id`=$id;";
        if (!$result = $db->query($sql)){
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
        $sql = "SELECT * FROM `tads`.`recado` WHERE `recado`.`id`=$id";
        if (!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        if ($recado = $result->fetch_object('app\DAO\Programador')){
            return $recado;
        }else{
            return false;
        }
    }

    public static function atualiza($id, $nome,$email,$cidade,$recado){
        $db = Conexao::conecta();
        $sql = "UPDATE `tads`.`recado` SET `nome`='$nome', `email`='$email', `cidade`='$cidade', `recado`='$recado' WHERE  `id`=$id";
        if (!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        return true;
    }

}