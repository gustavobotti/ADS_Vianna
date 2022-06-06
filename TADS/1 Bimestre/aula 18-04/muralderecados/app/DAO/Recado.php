<?php
namespace app\DAO;

use app\Conexao;

class Recado{
    private $nome;
    private $email;
    private $cidade;
    private $recado;

    public static function novo($nome,$email,$cidade,$recado){
        $db = Conexao::conecta();
        $sql = "INSERT INTO `tads`.`recado` (`nome`, `email`, `cidade`, `recado`) VALUES ('?', '?', '?', '?');";

        $stmt = $db->prepare($sql);
        $stmt->bind_param('ssss', $nome, $email, $cidade, $recado); // anti sql injection
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        return true;
    }
    
    public static function exibeRecados()
    {
        $db = Conexao::conecta();
        $sql = "SELECT * FROM `tads`.`recado`";
        if (!$result = $db->query($sql)){
            return false;
        }
        echo "<table border=1>";
            echo "<tr> 
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Cidade</th>
                    <th>Recado</th>
                    <th>Excluir</th>
                    <th>Alterar</th>
                </tr>";
            while ($recado = $result->fetch_object('app\DAO\Recado')) {
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
        $sql = "DELETE FROM `tads`.`recado` WHERE  `id`=?;";
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

    public static function retornaRecado($id)
    {
        $db = Conexao::conecta();
        $sql = "SELECT * FROM `tads`.`recado` WHERE `recado`.`id`=?";
        $stmt = $db->prepare($sql);
        $stmt->bind_param('i',$id);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        if ($recado = $result->fetch_object('app\DAO\Recado')){
            return $recado;
        }else{
            return false;
        }
    }

    public static function atualiza($id, $nome,$email,$cidade,$recado){
        $db = Conexao::conecta();
        $sql = "UPDATE `tads`.`recado` SET `nome`='?', `email`='?', `cidade`='?', `recado`='?' WHERE  `id`=?";
        $stmt = $db->prepare($sql);
        $stmt->bind_param('ssssi',$nome, $email, $cidade, $recado, $id);
        $stmt->execute();

        if (!$result = $stmt->get_result()){
            echo $db->error;
            return false;
        }
        return true;
    }

}