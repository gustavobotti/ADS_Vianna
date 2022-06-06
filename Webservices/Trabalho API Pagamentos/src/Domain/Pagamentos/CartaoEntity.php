<?php
namespace App\Domain\Pagamentos;

use Doctrine\ORM\Mapping as ORM;
use Ramsey\Uuid\Uuid;

/**
 * @ORM\Entity()
 * @ORM\Table(name="cartoes")
 */
class CartaoEntity
{
    /**
     * @ORM\Id()
     * @ORM\Column(name="id", type="guid", nullable=false)
     */
    protected string $id;

    /**
     * @ORM\Column(name="cpf_cliente", type="string", length=200, nullable=false)
     */
    protected string $cpfCliente;

    /**
     * @ORM\Column(name="numero_cartao", type="string", length=200, nullable=false)
     */
    protected string $numeroCartao;

    /**
     * @ORM\Column(name="saldo", type="decimal", precision=15, scale=2, nullable=false)
     */
    protected float $saldo;


    /**
     * CartaoEntity constructor.
     *
     * @param string $cpfCliente
     * @param string $numeroCartao
     * @param float  $saldo
     */
    public function __construct(
        string $cpfCliente,
        string $numeroCartao,
        float $saldo
    ) {
        $this->id = Uuid::uuid4();
        $this->cpfCliente = $cpfCliente;
        $this->numeroCartao = $numeroCartao;
        $this->saldo = $saldo;
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
     * @return CartaoEntity
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * @return string
     */
    public function getCpfCliente(): string
    {
        return $this->cpfCliente;
    }

    /**
     * @param string $cpfCliente
     *
     * @return CartaoEntity
     */
    public function setCpfCliente(string $cpfCliente): CartaoEntity
    {
        $this->cpfCliente = $cpfCliente;

        return $this;
    }

    /**
     * @return string
     */
    public function getNumeroCartao(): string
    {
        return $this->numeroCartao;
    }

    /**
     * @param string $numeroCartao
     *
     * @return CartaoEntity
     */
    public function setNumeroCartao(string $numeroCartao): CartaoEntity
    {
        $this->numeroCartao = $numeroCartao;

        return $this;
    }

    /**
     * @return float
     */
    public function getSaldo(): float
    {
        return $this->saldo;
    }

    /**
     * @param float $saldo
     *
     * @return CartaoEntity
     */
    public function setSaldo(float $saldo): CartaoEntity
    {
        $this->saldo = $saldo;

        return $this;
    }
}
