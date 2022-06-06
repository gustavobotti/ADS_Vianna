<?php

namespace App\Application\Actions\Livros;

use App\Domain\DomainException\DomainRecordNotFoundException;
use App\Domain\Livros\LivroServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Slim\Exception\HttpBadRequestException;
use Psr\Log\LoggerInterface;

class ListarLivrosAction extends \App\Application\Actions\Action
{
    protected LivroServiceOrm $livroServiceOrm;

    /**
     * ListarLivrosAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                $logger
     * @param \App\Domain\Livros\LivroServiceOrmServiceOrm $livroServiceOrm
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
        // Obter cartoes
        $livros = $this->livroServiceOrm->obterLivros();

        // Preparar dados dos cartões para retornar ao usuário
        $dadosLivros = [];
        foreach ($livros as $livro) {
            $dadosLivros[] = [
                'id' => $livro->getId(),
                'titulo' => $livro->getTitulo(),
                'autor' => $livro->getAutor(),
                'situacao' => $livro->getSituacao()
            ];
        }

        // Retonar dados ao usuário
        return $this->respondWithData($dadosLivros);
    }


}