<?php

namespace ApiClientSpotify\Models;

class Album
{
    protected string $nome;
    protected string $dataLancamento;
    protected array $nomeArtista = [];
    protected int $totalMusicas;
    protected int $totalDuracao;
    protected array $musicas = [];

//    /**
//     * @param string $nome
//     * @param string $dataLancamento
//     * @param string $nomeArtista
//     * @param string $totalMusicas
//     * @param string $totalDuracao
//     * @param string $musicas
//     */
//    public function __construct(string $nome, string $dataLancamento, string $nomeArtista, string $totalMusicas, string $totalDuracao, string $musicas)
//    {
//        $this->nome = $nome;
//        $this->dataLancamento = $dataLancamento;
//        $this->nomeArtista = $nomeArtista;
//        $this->totalMusicas = $totalMusicas;
//        $this->totalDuracao = $totalDuracao;
//        $this->musicas = $musicas;
//    }

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
    public function getDataLancamento(): string
    {
        return $this->dataLancamento;
    }

    /**
     * @param string $dataLancamento
     */
    public function setDataLancamento(string $dataLancamento): void
    {
        $this->dataLancamento = $dataLancamento;
    }

    /**
     * @return array
     */
    public function getNomeArtista(): array
    {
        return $this->nomeArtista;
    }

    /**
     * @param array $nomeArtista
     */
    public function setNomeArtista(array $nomeArtista): void
    {
        $this->nomeArtista = $nomeArtista;
    }

    /**
     * @return string
     */
    public function getTotalMusicas(): string
    {
        return $this->totalMusicas;
    }

    /**
     * @param string $totalMusicas
     */
    public function setTotalMusicas(string $totalMusicas): void
    {
        $this->totalMusicas = $totalMusicas;
    }

    /**
     * @return string
     */
    public function getTotalDuracao(): string
    {
        return $this->totalDuracao;
    }

    /**
     * @param string $totalDuracao
     */
    public function setTotalDuracao(string $totalDuracao): void
    {
        $this->totalDuracao = $totalDuracao;
    }

    /**
     * @return array
     */
    public function getMusicas(): array
    {
        return $this->musicas;
    }

    /**
     * @param array $musicas
     */
    public function setMusicas(array $musicas): void
    {
        $this->musicas = $musicas;
    }


    public function __construct()
    {
    }

    public function getMusicLenght()
    {
        $duracao = 0;
        foreach ( $this -> musicas as $musica ){
            $duracao += $musica -> getDuracao();
        }
        $this -> setTotalDuracao($duracao);
    }
}