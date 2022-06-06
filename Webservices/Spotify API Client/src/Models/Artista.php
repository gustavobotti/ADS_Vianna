<?php

namespace ApiClientSpotify\Models;

class Artista
{
    protected string $nome;
    protected array $musicas;
    protected array $albums;

    /**
     * @param string $nome
     * @param array $musicas
     * @param array $albums
     */
    public function __construct(string $nome, array $musicas, array $albums)
    {
        $this->nome = $nome;
        $this->musicas = $musicas;
        $this->albums = $albums;
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

    /**
     * @return array
     */
    public function getAlbums(): array
    {
        return $this->albums;
    }

    /**
     * @param array $albums
     */
    public function setAlbums(array $albums): void
    {
        $this->albums = $albums;
    }

}