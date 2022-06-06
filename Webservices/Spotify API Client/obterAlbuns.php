<?php
use ApiClientSpotify\Auth\TokenManager;
require 'vendor/autoload.php';

$tokenManager = new TokenManager();
$client = new \GuzzleHttp\Client();


// * //
$album = "3trdvZU971be8AFgYtoB1I"; //Insira aqui o id do album
// * //


$query = $album . "?query" . "&market=BR";
$url = 'https://api.spotify.com/v1/albums/' . $query;

$res = $client->get($url, [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

echo "<pre>";
var_dump(json_decode($res->getBody(), true));
echo "</pre>";

die;
