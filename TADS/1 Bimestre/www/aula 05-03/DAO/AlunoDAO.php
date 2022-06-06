<?php
namespace DAO;

class AlunoDAO{
    public $id;
    public $nome;
    public $instituição;

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
        echo "Teste"; // salvar um aluno no BD; deveremos usar o metodo query encontrado na php
    }
}