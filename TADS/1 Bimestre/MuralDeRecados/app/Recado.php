<?php
namespace app\DAO;

use app\Conexao;

class Recado{
    private $nome;
    private $email;
    private $cidade;
    private $recado;

    public static function novo($nome, $email, $cidade, $recado){
        $db = Conexao::conecta();
        $sql = "INSERT INTO `tads`.`recado` (`id`, `cidade`, `recado`, `nome`, `email`) VALUES ('1', '$nome', '$email', '$cidade', '$recado');";
        if(!$result = $db->query($sql)){
            echo $db->error;
            return false;
        }
        return true;
    }

}
?>