<?php

namespace App\Application\Actions\Livros;

use App\Domain\Livros\LivroEntity;
use App\Domain\Livros\LivroServiceOrm;
use App\Domain\Livros\LocacaoEntity;
use App\Domain\Livros\LocacaoServiceOrm;
use Psr\Log\LoggerInterface;
use App\Domain\DomainException\DomainRecordNotFoundException;
use Psr\Http\Message\ResponseInterface as Response;
use Slim\Exception\HttpBadRequestException;

class AlugarLivrosAction extends \App\Application\Actions\Action
{
    protected LivroServiceOrm $livroServiceOrm;
    protected LocacaoServiceOrm $locacaoServiceOrm;

    /**
     * AlugarLivrosAction constructor.
     *
     * @param \Psr\Log\LoggerInterface                   $logger
     * @param \App\Domain\Livros\LocacaoServiceOrm $locacaoServiceOrm
     */

    public function __construct(
        LoggerInterface $logger,
        LivroServiceOrm $livroServiceOrm,
        LocacaoServiceOrm $locacaoServiceOrm
    ) {
        parent::__construct($logger);

        $this->livroServiceOrm = $livroServiceOrm;
        $this->locacaoServiceOrm = $locacaoServiceOrm;
    }

    protected function action(): Response
    {
        // Criar padrão de retorno
        $retorno = [
            'status' => false,
            'msg'    => '',
            'dados'  => null,
        ];

        // Obter dados da locacao vindos da requisição
        $dadosLocacao = json_decode($this->request->getBody()->getContents(), true);


        /********************************/
        /* VALIDAR DADOS DA LOCACAO   */
        /********************************/
        // id do livro
        $id = $dadosLocacao['id'];
        $nome = $dadosLocacao['nome'];

        $livro = $this->livroServiceOrm->obterLivroPorId($id);


        if ($livro == false) {
            $retorno['msg'] = 'Livro não existente';

            return $this->respondWithData($retorno);
        } else if ($livro == true) {
            $disponibilidade = $livro->getSituacao();
            if ($disponibilidade == 'Disponível'){
                $livro->setSituacao(3);

                    $dataLocacao = date('Y-m-d H:i:s');


                    $dataDevolucao = date('Y-m-d', strtotime("+3 days"));



                    $newLocacao = $this->locacaoServiceOrm->inserirLocacao(
                        $livro,
                        $livro->getId(),
                        $nome,
                        $dataLocacao,
                        $dataDevolucao,
                    );

                $retorno['status'] = true;
                $retorno['msg'] = 'Livro alugado!';

            }else {
                $retorno['msg'] = 'Livro não está disponível';

            }
        }
        // Retonar dados ao usuário
        return $this->respondWithData($retorno);
    }
}





