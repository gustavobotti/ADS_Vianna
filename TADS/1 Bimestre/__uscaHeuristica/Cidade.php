<?php

class Cidade{
    private $cidade = ''; //nome cidade
    private $valor = ''; //valor heuristico
    private $vizinhos = Array(); //expansao dos filhos

    function __construct($cidade, $valor, $vizinhos)
    {
        $this->cidade = $cidade;
        $this->valor = $valor;
        $this->vizinhos = $vizinhos;
    }

    public function adicionaVizinho(Cidade $vizinho)
    {
        $this->vizinhos[] = $vizinho;
    }

    public function getValor()
    {
        return $this->valor;
    }

    public function setValor($valor)
    {
        $this->valor = $valor;
    }

    public function getCidade()
    {
        return $this->cidade;
    }

    public function setCidade($cidade)
    {
        $this->cidade = $cidade;
    }

    public function getVizinhos()
    {
        return $this->vizinhos;
    }

    public function setVizinhos($vizinhos)
    {
        $this->vizinhos = $vizinhos;
    }
}


?>