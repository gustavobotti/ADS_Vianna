<?php

namespace App\Application\Actions\Livros;

use App\Application\Actions\Action;
use App\Domain\Livros\LivroServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;
use Slim\Exception\HttpBadRequestException;

class CosultarLivrosAction extends \App\Application\Actions\Action
{
    protected LivroServiceOrm $livroServiceOrm;

    /**
     *
     * @param \Psr\Log\LoggerInterface                   $logger
     * @param \App\Domain\Livros\LivroServiceOrm $livroServiceOrm
     */

    public function __construct(
        LoggerInterface $logger,
        LivroServiceOrm $livroServiceOrm
    ) {
        parent::__construct($logger);

        $this->livroServiceOrm = $livroServiceOrm;
    }

    protected function action(): Response
    {
        // Obter id do livro a ser consultada
        $idLivro = $this->resolveArg('id');

        // Obter transação
        try {
            $livro = $this->livroServiceOrm->obterLivroPorId($idLivro);

            // Retornar os dados
            $dadosLivros = [
                'id' => $livro->getId(),
                'situacao' =>$livro->getSituacao(),
                'titulo' => $livro->getTitulo(),
                'autor' => $livro->getAutor(),
                'editor' => $livro->getEditora(),
                'ano' => $livro->getAno(),
                'numero_de_paginas' => $livro->getNumeroDePaginas()

            ];

            // Retonar dados ao usuário
            return $this->respondWithData($dadosLivros);

        } catch (\Exception $e) {
            $this->response->getBody()->write($e->getMessage());

            return $this->response->withStatus(404);
        }
    }

}