<?php

namespace App\Domain\Livros;
use Ramsey\Uuid\Uuid;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity()
 * @ORM\Table(name="locacoes")
 */

class LocacaoEntity
{
    /**
     * @ORM\id()
     * @ORM\Column(name="id", type="guid", nullable=false)
     */
    protected string $id;

    /**
     * @ORM\JoinColumn(name="id")
     * @ORM\ManyToOne(targetEntity="LivroEntity")
     */
    protected LivroEntity $livroId;

    /**
     * @ORM\Column(name="nome_locador", type="string", length=255, nullable=false)
     */
    protected string $nome_locador;

    /**
     * @ORM\Column(name="data_locacao", type="datetime", nullable=false)
     */
    private \DateTime  $data_locacao;


    /**
     * @ORM\Column(type="datetime")
     */
    private \DateTime $data_devolucao;

    /**
     * @param string $id
     * @param LivroEntity $livroId
     * @param string $nome_locador
     * @param \DateTime $data_locacao
     * @param \DateTime $data_devolucao
     */
    public function __construct(string $id, LivroEntity $livroId, string $nome_locador, \DateTime $data_locacao, \DateTime $data_devolucao)
    {
        $this->id = Uuid::uuid4();
        $this->livroId = $livroId;
        $this->nome_locador = $nome_locador;
        $this->data_locacao = $data_locacao;
        $this->data_devolucao = $data_devolucao;
    }

    /**
     * @return string
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
     * @return LivroEntity
     */
    public function getLivroId(): LivroEntity
    {
        return $this->livroId;
    }

    /**
     * @param LivroEntity $livroId
     */
    public function setLivroId(LivroEntity $livroId): void
    {
        $this->livroId = $livroId;
    }

    /**
     * @return string
     */
    public function getNomeLocador(): string
    {
        return $this->nome_locador;
    }

    /**
     * @param string $nome_locador
     */
    public function setNomeLocador(string $nome_locador): void
    {
        $this->nome_locador = $nome_locador;
    }

    /**
     * @return \DateTime
     */
    public function getDataLocacao(): \DateTime
    {
        return $this->data_locacao;
    }

    /**
     * @param \DateTime $data_locacao
     */
    public function setDataLocacao(\DateTime $data_locacao): void
    {
        $this->data_locacao = $data_locacao;
    }

    /**
     * @return \DateTime
     */
    public function getDataDevolucao(): \DateTime
    {
        return $this->data_devolucao;
    }

    /**
     * @param \DateTime $data_devolucao
     */
    public function setDataDevolucao(\DateTime $data_devolucao): void
    {
        $this->data_devolucao = $data_devolucao;
    }

}