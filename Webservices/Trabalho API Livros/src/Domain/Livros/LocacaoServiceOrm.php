<?php

namespace App\Domain\Livros;

use Doctrine\ORM\EntityManagerInterface;
use Doctrine\Persistence\ObjectRepository;
use Exception;

class LocacaoServiceOrm
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
     * @return \App\Domain\Livros\LocacaoEntity[]|object[]|null
     */

    public function obterLocacoes(array $filtros)
    {
        $criteria = new Criteria();

        if (isset($filtros['id'])) {
            $criteria->andWhere(
                $criteria->expr()->eq('id', $filtros['id'])
            );
        }

        return $this->em->getRepository(LocacaoEntity::class)->matching($criteria)->toArray();
    }

    /**
     * @param string $id
     *
     * @return \App\Domain\Livros\LocacaoEntity|null
     * @throws \Exception
     */
    public function obterLocacaoPorId(string $id): ?LocacaoEntity
    {
        /**
         * @var \App\Domain\Livros\LocacaoEntity $locacao
         */

        $locacao = $this->em->getRepository(LocacaoEntity::class)->find($id);

        if (!$locacao) {
            throw new Exception('Locação não encontrada');
        }

        return $locacao;
    }

    /**
     * @param \App\Domain\Livros\LocacaoEntity $locacao
     * @param string                              $livro_Id
     * @param string                              $nome_locador
     * @param string                              $data_locacao
     * @param string                              $data_devolucao
     *
     * @return \App\Domain\Livros\LocacaoEntity
     */
    public function inserirLocacao(LivroEntity $livro, string  $livro_Id, string $nome_locador, string $data_locacao, string $data_devolucao): LocacaoEntity
    {
        $novaLocacao = new LocacaoEntity($livro_Id, $nome_locador, $data_locacao, $data_devolucao);

        $this->em->persist($novaLocacao);
        $this->em->flush();

        return $novaLocacao;
    }

}