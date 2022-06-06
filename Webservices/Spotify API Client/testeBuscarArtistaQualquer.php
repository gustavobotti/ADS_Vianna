<?php
use ApiClientSpotify\Auth\TokenManager;
require 'vendor/autoload.php';

$tokenManager = new TokenManager();
$client = new \GuzzleHttp\Client();


// * //
$artista = "6EM7D8YUqKTFhM61WSEIDn"; //Insira aqui o id do artista
// * //

//$query = "?query=" . $artista . "&type=artist&limit=1";
$url = 'https://api.spotify.com/v1/artists/' . $artista;

$resArtista = $client->get($url, [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

$resTop10 = $client->get($url . '/top-tracks?market=BR', [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

$resAlbum = $client->get( $url . '/albums', [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

$resultArtista = json_decode( $resArtista -> getBody(), true );
$resultTop10 = json_decode( $resTop10 -> getBody(), true );
$resultAlbum = json_decode( $resAlbum -> getBody(), true );

echo "<pre>";

$musicas = [];
$albuns = [];

$novoArtista = new \ApiClientSpotify\Models\Artista($resultArtista['name'], $musicas, $albuns);

foreach ( $resultAlbum['items'] as $album ){
    $albums = $novoArtista -> getAlbums();
    array_push( $albums, $album['name'] );
    $novoArtista -> setAlbums( $albums );
}

foreach ( $resultTop10['tracks'] as $track ) {
    $musica = new \ApiClientSpotify\Models\Musica( $track['name'], $track['duration_ms'] );
    $musicas = $novoArtista -> getMusicas();
    array_push( $musicas, $musica );
    $novoArtista -> setMusicas( $musicas );
}

echo "<center><h2><h2> Nome:" . $novoArtista -> getNome() . "</h2></b><br>";
echo "<br> Albums: ";
foreach ( array_unique($novoArtista -> getAlbums()) as $novoAlbum ) {
    echo "<br> Nome: " . $novoAlbum;
}
echo "<br> Músicas: ";
foreach ( $novoArtista -> getMusicas() as $novoAlbum ) {
    echo "<br> Nome: " . $novoAlbum -> getNome();
    echo "<br> Duração: " . format( $novoAlbum -> getDuracao() );
}
echo "<br> </center>";

function format($ms)
{
    $seconds = floor($ms / 1000);
    $minutes = floor($seconds / 60);
    $hours = floor($minutes / 60);
    $seconds = $seconds % 60;
    $minutes = $minutes % 60;
    $format = '%u:%02u:%02u';
    $total = sprintf($format, $hours, $minutes, $seconds);
    return $total;
}

die;
