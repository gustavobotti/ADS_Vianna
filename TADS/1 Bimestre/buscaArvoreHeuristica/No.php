<?php

class No{
    private $valor = '';
    private $filhos = Array();
    private $heuristica = 0.0;

    function __construct($valor, $heuristica)
    {
        $this->valor = $valor;
        $this->heuristica = $heuristica;
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

    public function getHeuristica()
    {
        return $this->heuristica;
    }

    public function getOrdenados()
    {
        $filhos = $this->getFilhos();
        $ordenados = Array();
        foreach($filhos as $filho)
        {
            $i = $filho->getHeuristica();
            $ordenados["$i"] = $filho;
        }
        ksort($ordenados);

        return $ordenados;
    }
}




?>