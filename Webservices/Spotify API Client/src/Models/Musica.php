<?php

namespace ApiClientSpotify\Models;

class Musica
{
    protected string $nome;
    protected string $duracao;

    /**
     * @param string $nome
     * @param string $duracao
     */
    public function __construct(string $nome, string $duracao)
    {
        $this->nome = $nome;
        $this->duracao = $duracao;
    }

    /**
     * @return string
     */
    public function getNome(): string
    {
        return $this->nome;
    }

    /**
     * @param string $nome
     */
    public function setNome(string $nome): void
    {
        $this->nome = $nome;
    }

    /**
     * @return string
     */
    public function getDuracao(): string
    {
        return $this->duracao;
    }

    /**
     * @param string $duracao
     */
    public function setDuracao(string $duracao): void
    {
        $this->duracao = $duracao;
    }

}