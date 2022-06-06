<?php
declare(strict_types=1);

use App\Application\Actions\Pagamentos\ConsultarTransacaoAction;
use App\Application\Actions\Pagamentos\ListarCartoesAction;
use App\Application\Actions\Pagamentos\ListarTransacoesAction;
use App\Application\Actions\Pagamentos\RealizarTransacaoAction;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Slim\App;

return function (App $app) {
    $app->options('/{routes:.*}', function (Request $request, Response $response) {
        // CORS Pre-Flight OPTIONS Request Handler
        return $response;
    });

    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write('API Pagamentos');
        return $response;
    });

    // Rotas da API de Pagamentos
    $app->get('/cartoes', ListarCartoesAction::class);
    $app->get('/transacoes', ListarTransacoesAction::class);
    $app->get('/transacoes/{id}', ConsultarTransacaoAction::class);
    $app->post('/transacoes', RealizarTransacaoAction::class);
};
