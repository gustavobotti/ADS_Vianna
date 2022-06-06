<?php

class Custo{
    private $ultimo = '';
    private $cidade = '';
    private $aresta = 0;
    private $custo = 0;
    private $func = 0;

    function __construct($ultimo, $cidade, $aresta, $custo, $func)
    {
        $this->ultimo = $ultimo;
        $this->cidade = $cidade;
        $this->aresta = $aresta;
        $this->custo = $custo;
        $this->func = $func;
    }

    public function getUltimo()
    {
        return $this->ultimo;
    }

    public function setUltimo($ultimo)
    {
        $this->ultimo = $ultimo;
    }

    public function getCidade()
    {
        return $this->cidade;
    }

    public function setCidade($cidade)
    {
        $this->cidade = $cidade;
    }

    public function getAresta()
    {
        return $this->aresta;
    }

    public function setAresta($aresta)
    {
        $this->aresta = $aresta;
    }

    public function getCusto()
    {
        return $this->custo;
    }

    public function setCusto($custo)
    {
        $this->custo = $custo;
    }

    public function getFunc()
    {
        return $this->func;
    }

    public function setFunc($func)
    {
        $this->func = $func;
    }
}


?>