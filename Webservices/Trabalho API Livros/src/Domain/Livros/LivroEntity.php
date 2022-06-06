<?php


namespace App\Domain\Livros;

use Doctrine\ORM\Mapping as ORM;

use Ramsey\Uuid\Uuid;

/**
 * @ORM\Entity()
 * @ORM\Table(name="livros")
 */

class LivroEntity
{
    /**
     * @ORM\id()
     * @ORM\Column(name="id", type="guid", nullable=false)
     */
    public string $id;

    /**
     * @ORM\Column(name="situacao", type="integer", nullable=false)
     */
    protected int $situacao;

    /**
     * @ORM\Column(name="titulo", type="string", length=255, nullable=false)
     */
    protected string $titulo;

    /**
     * @ORM\Column(name="autor", type="string", length=255, nullable=false)
     */
    protected string $autor;

    /**
     * @ORM\Column(name="editora", type="string", length=255, nullable=false)
     */
    protected string $editora;

    /**
     * @ORM\Column(name="ano", type="integer", nullable=false)
     */
    protected int $ano;

    /**
     * @ORM\Column(name="numero_de_paginas", type="integer", nullable=false)
     */
    protected int $numero_de_paginas;

    /**
     * @param int $situacao
     * @param string $titulo
     * @param string $autor
     * @param string $editora
     * @param int $ano
     * @param int $numero_de_paginas
     */
    public function __construct(
        string $id,
        int $situacao,
        string $titulo,
        string $autor,
        string $editora,
        int $ano,
        int $numero_de_paginas
    ) {
        $this->id = Uuid::uuid4();
        $this->situacao = $situacao;
        $this->titulo = $titulo;
        $this->autor = $autor;
        $this->editora = $editora;
        $this->ano = $ano;
        $this->numero_de_paginas = $numero_de_paginas;
    }
    /* GETTERS/SETTERS */
    /**
     * @return \Ramsey\Uuid\UuidInterface|string
     */
    public function getId(): string
    {
        return $this->id;
    }

    /**
     * @param string $id
     */
    public function setId(string $id): void
    {
        $this->id = $id;
    }

    /**
     * @return int
     */
    public function getSituacao(): string
    {
        if ($this->situacao == 1){
            return 'Disponível';
        }

        else if ($this->situacao == 2){
            return 'Indisponivel';
        }

        else {
            return 'Alugado';
        }

    }

    /**
     * @param int $situacao
     */
    public function setSituacao(int $situacao): void
    {
        $this->situacao = $situacao;
    }

    /**
     * @return string
     */
    public function getTitulo(): string
    {
        return $this->titulo;
    }

    /**
     * @param string $titulo
     */
    public function setTitulo(string $titulo): void
    {
        $this->titulo = $titulo;
    }

    /**
     * @return string
     */
    public function getAutor(): string
    {
        return $this->autor;
    }

    /**
     * @param string $autor
     */
    public function setAutor(string $autor): void
    {
        $this->autor = $autor;
    }

    /**
     * @return string
     */
    public function getEditora(): string
    {
        return $this->editora;
    }

    /**
     * @param string $editora
     */
    public function setEditora(string $editora): void
    {
        $this->editora = $editora;
    }

    /**
     * @return int
     */
    public function getAno(): int
    {
        return $this->ano;
    }

    /**
     * @param int $ano
     */
    public function setAno(int $ano): void
    {
        $this->ano = $ano;
    }

    /**
     * @return int
     */
    public function getNumeroDePaginas(): int
    {
        return $this->numero_de_paginas;
    }

    /**
     * @param int $numero_de_paginas
     */
    public function setNumeroDePaginas(int $numero_de_paginas): void
    {
        $this->numero_de_paginas = $numero_de_paginas;
    }



}