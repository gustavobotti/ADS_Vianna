<?php
namespace App\Application\Actions\Pagamentos;

use App\Application\Actions\Action;
use App\Domain\Pagamentos\TransacaoServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;

class ListarTransacoesAction extends Action
{
    protected TransacaoServiceOrm $transacaoServiceOrm;

    /**
     * ListarTransacoesAction constructor.
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
        // Obter filtros via QueryString
        $filtros = $this->request->getQueryParams();

        // Obter transações
        $transacoes = $this->transacaoServiceOrm->obterTransacoes($filtros);

        // Preparar dados das transações para retornar ao usuário
        $dadosTransacoes = [];
        foreach ($transacoes as $transacao) {
            $dadosTransacoes[] = [
                'idTransacao'         => $transacao->getId(),
                'idSituacaoTransacao' => $transacao->getIdSituacaoTransacao(),
                'valor'               => $transacao->getValor()
            ];
        }

        // Retonar dados ao usuário
        return $this->respondWithData($dadosTransacoes);
    }
}
