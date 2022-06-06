<?php
namespace App\Application\Actions\Pagamentos;

use App\Application\Actions\Action;
use App\Domain\Pagamentos\CartaoServiceOrm;
use App\Domain\Pagamentos\SituacaoTransacaoEntity;
use App\Domain\Pagamentos\TransacaoServiceOrm;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;

class RealizarTransacaoAction extends Action
{
    protected CartaoServiceOrm $cartaoServiceOrm;
    protected TransacaoServiceOrm $transacaoServiceOrm;

    /**
     * RealizarTransacaoAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                   $logger
     * @param \App\Domain\Pagamentos\CartaoServiceOrm    $cartaoServiceOrm
     * @param \App\Domain\Pagamentos\TransacaoServiceOrm $transacaoServiceOrm
     */
    public function __construct(
        LoggerInterface $logger,
        CartaoServiceOrm $cartaoServiceOrm,
        TransacaoServiceOrm $transacaoServiceOrm
    ) {
        parent::__construct($logger);

        $this->cartaoServiceOrm = $cartaoServiceOrm;
        $this->transacaoServiceOrm = $transacaoServiceOrm;
    }


    protected function action(): Response
    {
        // Criar padrão de retorno
        $retorno = [
            'status' => false,
            'msg'    => '',
            'dados'  => null,
        ];

        // Obter dados da transação vindos da requisição
        $dadosTransacao = json_decode($this->request->getBody()->getContents(), true);


        /********************************/
        /* VALIDAR DADOS DA TRANSAÇÃO   */
        /********************************/
        // Número do cartão
        $numeroCartao = $dadosTransacao['numeroCartao'] ?? null;

        if (!$numeroCartao) {
            $retorno['msg'] = 'Necessário informar [numeroCartao]';

            return $this->respondWithData($retorno);
        }

        $cartaoExistente = $this->cartaoServiceOrm->obterCartaoPorNumero($numeroCartao);

        if (!$cartaoExistente) {
            $retorno['msg'] = 'Cartão Inexistente';

            return $this->respondWithData($retorno);
        }

        // Valor da transação
        $valor = $dadosTransacao['valor'] ?? null;

        if (!$valor) {
            $retorno['msg'] = 'Necessário informar [valor]';

            return $this->respondWithData($retorno);
        }


        /********************************/
        /* CRIAR NOVA TRANSAÇÃO         */
        /********************************/
        // Validar valor de acordo com saldo do cartão
        $novoSaldo = $cartaoExistente->getSaldo() - $valor;

        if ($cartaoExistente->getSaldo() >= $valor) {
            $idSituacaoTransacao = SituacaoTransacaoEntity::SUCESSO;
            $observacao = 'Transação Aprovada';
        } else {
            $idSituacaoTransacao = SituacaoTransacaoEntity::FALHA;
            $observacao = 'Saldo insuficiente';
        }

        try {
            $novaTransacao = $this->transacaoServiceOrm->inserirTransacao(
                $cartaoExistente,
                $valor,
                $idSituacaoTransacao,
                $observacao
            );

            // Atualizar o saldo do cartão
            if ($idSituacaoTransacao == SituacaoTransacaoEntity::SUCESSO) {
                $this->cartaoServiceOrm->atualizarSaldoCartao($cartaoExistente, $novoSaldo);

                $retorno['dados'] = [
                    'idTransacao' => $novaTransacao->getId(),
                ];
            }

            $retorno['status'] = true;
            $retorno['msg'] = $observacao;

        } catch (\Exception $exception) {
            $retorno['msg'] = $exception->getMessage();
        }

        // Retonar dados ao usuário
        return $this->respondWithData($retorno);
    }
}
