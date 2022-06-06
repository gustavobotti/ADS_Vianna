<?php

namespace App\Application\Actions\Livros;

use App\Application\Actions\Action;
use App\Domain\Livros\LocacaoServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;

class ConsultarLocacaoAction extends Action
{
    protected LocacaoServiceOrm $locacaoServiceOrm;

    /**
     * ConsultarLocacaoAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                   $logger
     * @param \App\Domain\Livros\LocacaoServiceOrm $locacaoServiceOrm
     */
    public function __construct(
        LoggerInterface $logger,
        LocacaoServiceOrm $locacaoServiceOrm
    ) {
        parent::__construct($logger);

        $this->locacaoServiceOrm = $locacaoServiceOrm;
    }

    protected function action(): Response
    {
        // Obter id locacao a ser consutlada
        $idLocacao = $this->resolveArg('id');

        // Obter locacao
        try {
            $locacao = $this->locacaoServiceOrm->obterLocacaoPorId($idLocacao);

            // Retornar os dados da locação
            $retorno = [
                'id'         => $locacao->getId(),
                'livroId'   => $locacao->getLivroId(),
                'nome_locador' => $locacao->getNomeLocador(),
                'data_locacao' => $locacao->getDataLocacao(),
                'data_devolucao' => $locacao->getDataDevolucao()

            ];

            // Retonar dados ao usuário
            return $this->respondWithData($retorno);

        } catch (\Exception $e) {
            $this->response->getBody()->write($e->getMessage());

            return $this->response->withStatus(404);
        }
    }





}