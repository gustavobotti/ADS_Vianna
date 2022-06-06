<?php
namespace App\Domain\Pagamentos;

use Doctrine\ORM\Mapping as ORM;
use Ramsey\Uuid\Uuid;

/**
 * @ORM\Entity()
 * @ORM\Table(name="transacoes")
 */
class TransacaoEntity
{
    /**
     * @ORM\Id()
     * @ORM\Column(name="id", type="guid", nullable=false)
     */
    protected string $id;

    /**
     * @ORM\JoinColumn(name="id_cartao")
     * @ORM\ManyToOne(targetEntity="CartaoEntity")
     */
    protected CartaoEntity $cartao;

    /**
     * @ORM\Column(name="valor", type="decimal", precision=15, scale=2, nullable=false)
     */
    protected float $valor;

    /**
     * @ORM\Column(name="id_situacao_transacao", type="integer", nullable=false)
     */
    protected int $idSituacaoTransacao;

    /**
     * @ORM\Column(name="observacao", type="string", length=200, nullable=false)
     */
    protected string $observacao;


    /**
     * TransacaoEntity constructor.
     *
     * @param \App\Domain\Pagamentos\CartaoEntity $cartao
     * @param float                               $valor
     * @param int                                 $idSituacaoTransacao
     * @param string                              $observacao
     */
    public function __construct(
        CartaoEntity $cartao,
        float $valor,
        int $idSituacaoTransacao,
        string $observacao
    ){
        $this->id = Uuid::uuid4();
        $this->cartao = $cartao;
        $this->valor = $valor;
        $this->idSituacaoTransacao = $idSituacaoTransacao;
        $this->observacao = $observacao;
    }


    /* GETTERS/SETTERS */

    /**
     * @return \Ramsey\Uuid\UuidInterface|string
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param \Ramsey\Uuid\UuidInterface|string $id
     *
     * @return TransacaoEntity
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * @return \App\Domain\Pagamentos\CartaoEntity
     */
    public function getCartao(): CartaoEntity
    {
        return $this->cartao;
    }

    /**
     * @param \App\Domain\Pagamentos\CartaoEntity $cartao
     *
     * @return TransacaoEntity
     */
    public function setCartao(CartaoEntity $cartao): TransacaoEntity
    {
        $this->cartao = $cartao;

        return $this;
    }

    /**
     * @return float
     */
    public function getValor(): float
    {
        return $this->valor;
    }

    /**
     * @param float $valor
     *
     * @return TransacaoEntity
     */
    public function setValor(float $valor): TransacaoEntity
    {
        $this->valor = $valor;

        return $this;
    }

    /**
     * @return int
     */
    public function getIdSituacaoTransacao(): int
    {
        return $this->idSituacaoTransacao;
    }

    /**
     * @param int $idSituacaoTransacao
     *
     * @return TransacaoEntity
     */
    public function setIdSituacaoTransacao(int $idSituacaoTransacao): TransacaoEntity
    {
        $this->idSituacaoTransacao = $idSituacaoTransacao;

        return $this;
    }

    /**
     * @return string
     */
    public function getObservacao(): string
    {
        return $this->observacao;
    }

    /**
     * @param string $observacao
     *
     * @return TransacaoEntity
     */
    public function setObservacao(string $observacao): TransacaoEntity
    {
        $this->observacao = $observacao;

        return $this;
    }
}
