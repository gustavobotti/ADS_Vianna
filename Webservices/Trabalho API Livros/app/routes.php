<?php
declare(strict_types=1);
use App\Application\Actions\Livros;
use App\Application\Actions\Livros\CosultarLivrosAction;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;

use Slim\App;

return function (App $app) {
    $app->options('/{routes:.*}', function (Request $request, Response $response) {
        // CORS Pre-Flight OPTIONS Request Handler
        return $response;
    });

    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write('API Biblioteca');
        return $response;
    });

    $app->get('/livros', \App\Application\Actions\Livros\ListarLivrosAction::class);

    $app->get('/livros/{id}', CosultarLivrosAction::class);

    $app->get('/locacoes/{id}', Livros\ConsultarLocacaoAction::class);

    $app->post('/locacoes', Livros\AlugarLivrosAction::class);

};
