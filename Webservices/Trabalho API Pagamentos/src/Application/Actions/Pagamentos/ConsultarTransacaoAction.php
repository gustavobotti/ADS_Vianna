<?php
namespace App\Application\Actions\Pagamentos;

use App\Application\Actions\Action;
use App\Domain\Pagamentos\TransacaoServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;

class ConsultarTransacaoAction extends Action
{
    protected TransacaoServiceOrm $transacaoServiceOrm;

    /**
     * RealizarTransacaoAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                   $logger
     * @param \App\Domain\Pagamentos\TransacaoServiceOrm $transacaoServiceOrm
     */
    public function __construct(
        LoggerInterface $logger,
        TransacaoServiceOrm $transacaoServiceOrm
    ) {
        parent::__construct($logger);

        $this->transacaoServiceOrm = $transacaoServiceOrm;
    }


    protected function action(): Response
    {
        // Obter id da transação a ser consultada
        $idTransacao = $this->resolveArg('id');

        // Obter transação
        try {
            $transacao = $this->transacaoServiceOrm->obterTransacaoPorId($idTransacao);

            // Retornar os dados da transação
            $retorno = [
                'idTransacao'         => $transacao->getId(),
                'idSituacaoTransacao' => $transacao->getIdSituacaoTransacao(),
                'valor'               => $transacao->getValor(),
                'numeroCartao'        => $transacao->getCartao()->getNumeroCartao(),
            ];

            // Retonar dados ao usuário
            return $this->respondWithData($retorno);

        } catch (\Exception $e) {
            $this->response->getBody()->write($e->getMessage());

            return $this->response->withStatus(404);
        }
    }
}
