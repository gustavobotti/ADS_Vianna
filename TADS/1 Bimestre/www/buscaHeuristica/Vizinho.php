<?php

class Vizinho{
    private $cidade = '';
    private $aresta = '';

    function __construct($cidade, $aresta)
    {
        $this->cidade = $cidade;
        $this->aresta = $aresta;
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
}


?>