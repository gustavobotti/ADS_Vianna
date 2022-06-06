<?php

class Pessoa{
    public $nome;
    public $cpf;
    public $idade;

    public function __construct(string $nome = '', int $cpf = 0, int $idade = 0)
    {
        $this->nome = $nome;
        $this->cpf = $cpf;
        $this->idade = $idade;
    }

    public function exibeDados()
    {
        echo "<p>";
        echo "Nome: {$this->nome} <br>";
        echo "CPF: {$this->cpf} <br>";
        echo "Idade: {$this->idade} <br>";
        echo "</p>";
    }
}