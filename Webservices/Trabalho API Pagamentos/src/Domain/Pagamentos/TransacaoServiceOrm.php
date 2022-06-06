<?php
namespace App\Domain\Pagamentos;

use Doctrine\Common\Collections\Criteria;
use Doctrine\ORM\EntityManagerInterface;
use Exception;

class TransacaoServiceOrm
{
    protected EntityManagerInterface $em;


    /**
     * TransacaoServiceOrm constructor.
     *
     * @param \Doctrine\ORM\EntityManagerInterface $em
     */
    public function __construct(
        EntityManagerInterface $em
    ) {
        $this->em = $em;
    }


    /**
     * @param array $filtros
     *
     * @return \App\Domain\Pagamentos\TransacaoEntity[]|object[]|null
     */
    public function obterTransacoes(array $filtros)
    {
        $criteria = new Criteria();

        if (isset($filtros['id-situacao-transacao'])) {
            $criteria->andWhere(
                $criteria->expr()->eq('idSituacaoTransacao', $filtros['id-situacao-transacao'])
            );
        }

        if (isset($filtros['valor-minimo'])) {
            $criteria->andWhere(
                $criteria->expr()->gte('valor', $filtros['valor-minimo']),
            );
        }

        if (isset($filtros['valor-maximo'])) {
            $criteria->andWhere(
                $criteria->expr()->lte('valor', $filtros['valor-maximo']),
            );
        }

        return $this->em->getRepository(TransacaoEntity::class)->matching($criteria)->toArray();
    }

    /**
     * @param string $idTransacao
     *
     * @return \App\Domain\Pagamentos\TransacaoEntity|null
     * @throws \Exception
     */
    public function obterTransacaoPorId(string $idTransacao): ?TransacaoEntity
    {
        /**
         * @var \App\Domain\Pagamentos\TransacaoEntity $transacao
         */

        $transacao = $this->em->getRepository(TransacaoEntity::class)->find($idTransacao);

        if (!$transacao) {
            throw new Exception('Transação não encontrada');
        }

        return $transacao;
    }

    /**
     * @param \App\Domain\Pagamentos\CartaoEntity $cartao
     * @param float                               $valor
     * @param int                                 $idSituacaoTransacao
     * @param string                              $observacao
     *
     * @return \App\Domain\Pagamentos\TransacaoEntity
     */
    public function inserirTransacao(CartaoEntity $cartao, float $valor, int $idSituacaoTransacao, string $observacao): TransacaoEntity
    {
        $novaTransacao = new TransacaoEntity($cartao, $valor, $idSituacaoTransacao, $observacao);

        $this->em->persist($novaTransacao);
        $this->em->flush();

        return $novaTransacao;
    }
}
