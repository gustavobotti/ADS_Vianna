<?php
namespace app;
use mysqli;

class Conexao{
    public static $conexao = null;
    public static function conecta(){
        if (self::$conexao == null){
            self::$conexao = new mysqli('localhost','root','aluno','tads',3306);  
        }
        return self::$conexao;
    }
}