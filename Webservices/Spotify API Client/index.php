<?php
use ApiClientSpotify\Auth\TokenManager;

require 'vendor/autoload.php';

$tokenManager = new TokenManager();


$client = new \GuzzleHttp\Client();

####editar####
$pesquisa = "pink+floyd"; // nome do album,artist,playlist,track,show,episode
$tipo = "artist"; // album,artist,playlist,track,show,episode
####editar####

$query = "?query=" . $pesquisa . "&type=" . $tipo . "&limit=1";
$url = 'https://api.spotify.com/v1/search' . $query;

$res = $client->get($url, [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

echo "<pre>";
var_dump(json_decode($res->getBody(), true));
echo "</pre>";

die;
















