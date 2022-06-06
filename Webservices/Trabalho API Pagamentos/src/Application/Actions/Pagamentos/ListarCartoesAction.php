<?php
namespace App\Application\Actions\Pagamentos;

use App\Application\Actions\Action;
use App\Domain\Pagamentos\CartaoServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;

class ListarCartoesAction extends Action
{
    protected CartaoServiceOrm $cartaoServiceOrm;

    /**
     * ListarCartoesAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                $logger
     * @param \App\Domain\Pagamentos\CartaoServiceOrm $cartaoServiceOrm
     */
    public function __construct(
        LoggerInterface $logger,
        CartaoServiceOrm $cartaoServiceOrm
    ) {
        parent::__construct($logger);

        $this->cartaoServiceOrm = $cartaoServiceOrm;
    }


    protected function action(): Response
    {
        // Obter cartoes
        $cartoes = $this->cartaoServiceOrm->obterCartoes();

        // Preparar dados dos cartões para retornar ao usuário
        $dadosCartoes = [];
        foreach ($cartoes as $cartao) {
            $dadosCartoes[] = [
                'cpfCliente'      => $cartao->getCpfCliente(),
                'numeroCartao'    => $cartao->getNumeroCartao(),
                'saldoDisponivel' => $cartao->getSaldo(),
            ];
        }

        // Retonar dados ao usuário
        return $this->respondWithData($dadosCartoes);
    }
}
