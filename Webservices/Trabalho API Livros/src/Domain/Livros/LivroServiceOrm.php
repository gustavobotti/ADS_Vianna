<?php

namespace App\Domain\Livros;

use Doctrine\ORM\EntityManagerInterface;
use Doctrine\Persistence\ObjectRepository;
use Exception;

class LivroServiceOrm
{
    protected EntityManagerInterface $em;
    protected ObjectRepository $repositoryLivro;

    /**
     * LivroServiceOrm constructor.
     *
     * @param \Doctrine\ORM\EntityManagerInterface $em
     */
    public function __construct(EntityManagerInterface $em)
    {
        $this->em = $em;
        $this->repositoryLivro = $this->em->getRepository(LivroEntity::class);
    }

    /**
     * @return \App\Domain\Livros\LivroEntity[]
     */

    public function obterLivros(): array
    {
        /**
         * @var \App\Domain\Livros\LivroEntity[] $livros
         */

        $livros = $this->repositoryLivro->findAll();

        return $livros;
    }

    public function obterLivroPorId($idLivro): ?LivroEntity
    {
        /**
         * @var \App\Domain\Livros\LivroEntity $livro
         */

        $livro = $this->em->getRepository(LivroEntity::class)->find($idLivro);

        if (!$livro) {
            throw new Exception('Livro não encontrado!');
        }

        return $livro;
    }





}