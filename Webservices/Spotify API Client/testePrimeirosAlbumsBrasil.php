<?php
use ApiClientSpotify\Auth\TokenManager;

require 'vendor/autoload.php';

$tokenManager = new TokenManager();
$client = new \GuzzleHttp\Client();

$query = "?country=BR&limit=5";
$url = 'https://api.spotify.com/v1/browse/new-releases' . $query;

$res = $client->get($url, [
    'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get(),
    ],
]);

$result = json_decode( $res->getBody(), true );

echo "<pre>";

$resultado = [];

foreach ( $result as $r ){
    foreach ( $r['items'] as $album ){
        $novoAlbum = new \ApiClientSpotify\Models\Album();
        $novoAlbum -> setNome( $album['name'] );
        $data = new DateTime( $album['release_date'] );
        $novoAlbum -> setDataLancamento( $data -> format( 'd/m/y' ) );
        $nomeArtistas = $novoAlbum -> getNomeArtista();
        foreach ( $album['artists'] as $artist ){
            array_push( $nomeArtistas, $artist['name'] );
        }
        $novoAlbum -> setNomeArtista( $nomeArtistas );
        $novoAlbum -> setTotalMusicas( $album['total_tracks'] );
        musicas( $novoAlbum, $album['id'], $tokenManager, $client );
        $novoAlbum -> getMusicLenght();
        array_push( $resultado, $novoAlbum );
    }
}

foreach ($resultado as $novoAlbum ){
    echo "<center><b><h2> Nome: ".$novoAlbum -> getNome();
    echo "</h2></b><br> Data: ".$novoAlbum -> getDataLancamento();
    echo "<br> Artistas: ";
    foreach ( $novoAlbum -> getNomeArtista() as $nome ){
        echo "<br> Artista: ".$nome;
    }
    echo "<br> Número de músicas: ".$novoAlbum -> getTotalMusicas();
    echo "<br> Músicas: ";
    foreach ( $novoAlbum -> getMusicas() as $musica ){
        echo "<br> Música: ".$musica -> getNome();
        echo "<br> Duração: ".format( $musica -> getDuracao() );
    }
    echo "<br> Duração total: ".format( $novoAlbum -> getTotalDuracao() );
    echo "<br> ";
    echo "<br> ";
    echo "<br> ";
    echo "<br> ";
    echo "<br> </center>";
}

function musicas(\ApiClientSpotify\Models\Album $novoAlbum, mixed $id, TokenManager $tokenManager, \GuzzleHttp\Client $client)
{
    $album_url = "https://api.spotify.com/v1/albums/" . $id . "/tracks?&limit=5";
    $res = $client -> get( $album_url, [ 'headers' => [
        'Authorization' => "Bearer " . $tokenManager->get()] ] );
    $tracks = json_decode( $res->getBody(), true );
    foreach ( $tracks['items'] as $track ) {
        $musica = new \ApiClientSpotify\Models\Musica( $track['name'], $track['duration_ms']);
        $musicas = $novoAlbum -> getMusicas();
        array_push($musicas, $musica);
        $novoAlbum -> setMusicas($musicas);
    }

}

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

echo "</pre>";

die;

















