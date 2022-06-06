<?php
namespace app;
use mysqli;

class Conexao{
    public static $conexao = null;

    public static function conecta()
    {
        if (self::$conexao/*Conexao::$conexao;*/ == null){
            self::$conexao = new mysqli('localhost', 'root', 'root', 'tads', 3308);            
        } 
        return self::$conexao;
        
    }
}

?>