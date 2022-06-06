<?php

class No{
    private $valor = '';
    private $filhos = Array();

    function __construct($valor)
    {
        $this->valor = $valor;
    }

    public function adicionaFilho(No $filho)
    {
        $this->filhos[] = $filho;
    }

    public function getValor()
    {
        return $this->valor;
    }

    public function setValor($valor)
    {
        $this->valor = $valor;
    }

    public function getFilhos()
    {
        return $this->filhos;
    }

    public function setFilhos($filhos)
    {
        $this->filhos = $filhos;
    }
}




?>