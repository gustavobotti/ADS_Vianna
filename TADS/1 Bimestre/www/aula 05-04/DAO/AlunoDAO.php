<?php
namespace DAO;

class AlunoDAO{
    public $id;
    public $nome;
    public $instituicao;

    public function printData()
    {
        echo "<p>";
        echo "ID: {$this->id} - Nome: {$this->nome}";
        echo "<p>";
    }

    //public function __construct($id = 0, $nome = '')
    //{
        //$this->id = $id;
        //$this->nome = $nome;
    //}

    public static function save($conexao,$nome)
    {
        $sql = "INSERT INTO 'tads'.'aluno' ('nome') VALUES ('$nome');";
        if(!$result = $conexao->query($sql)){
            return false;
        }
        return true;
    }
}