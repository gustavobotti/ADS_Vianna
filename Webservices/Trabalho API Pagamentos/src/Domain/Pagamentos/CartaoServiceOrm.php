<?php
namespace App\Domain\Pagamentos;

use Doctrine\ORM\EntityManagerInterface;
use Doctrine\Persistence\ObjectRepository;
use Exception;

class CartaoServiceOrm
{
    protected EntityManagerInterface $em;
    protected ObjectRepository $repositoryCartao;

    /**
     * CartaoServiceOrm constructor.
     *
     * @param \Doctrine\ORM\EntityManagerInterface $em
     */
    public function __construct(EntityManagerInterface $em)
    {
        $this->em = $em;
        $this->repositoryCartao = $this->em->getRepository(CartaoEntity::class);

    }

    /**
     * @return \App\Domain\Pagamentos\CartaoEntity[]
     */
    public function obterCartoes(): array
    {
        /**
         * @var \App\Domain\Pagamentos\CartaoEntity[] $cartoes
         */

        $cartoes = $this->repositoryCartao->findAll();

        return $cartoes;
    }

    /**
     * @param string $numeroCartao
     *
     * @return \App\Domain\Pagamentos\CartaoEntity|null
     * @throws \Exception
     */
    public function obterCartaoPorNumero(string $numeroCartao): ?CartaoEntity
    {
        /**
         * @var \App\Domain\Pagamentos\CartaoEntity $cartao
         */

        $cartao = $this->repositoryCartao->findOneBy([
            'numeroCartao' => $numeroCartao,
        ]);

        if (!$cartao) {
            throw new Exception('Cartão não encontrado');
        }

        return $cartao;
    }

    /**
     * @param \App\Domain\Pagamentos\CartaoEntity $cartao
     * @param                                     $novoSaldo
     *
     * @return \App\Domain\Pagamentos\CartaoEntity
     */
    public function atualizarSaldoCartao(CartaoEntity $cartao, $novoSaldo): CartaoEntity
    {
        $cartao->setSaldo($novoSaldo);

        $this->em->persist($cartao);
        $this->em->flush();

        return $cartao;
    }
}
