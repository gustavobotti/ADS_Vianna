<?php
require_once 'Pessoa.php';

class Aluno extends Pessoa{

    public $matricula;

    public function __construct(string $nome = '', int $idade = 0, int $cpf = 0, int $matricula = 0){
        parent::__construct($nome,$cpf,$idade);
        $this->matricula = $matricula;
    }

    public function exibeNome()
    {
        echo $this->nome;
    }

    public function exibeAtributo(string $atributo)
    {
        echo $this->$atributo;
    }
	
	public static function exibeIntro()
    {
        
    }
}