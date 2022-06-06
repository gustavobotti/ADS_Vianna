<?php
namespace ApiClientSpotify\Auth;

use DateInterval;
use DateTime;
use GuzzleHttp\Client;

class TokenManager
{
    const CLIENT_ID = 'f59c1b639e634b7d99c8a2af3a6dcde0';
    const CLIENT_SECRET = 'c30021496c1b492ba29be44a9d2010fe';

    private ?string $token = null;
    private ?DateTime $dataExpiracaoToken = null;


    /**
     * @throws \GuzzleHttp\Exception\GuzzleException
     * @throws \Exception
     */
    private function setFromSpotify()
    {
        $client = new Client();

        $res = $client->post('https://accounts.spotify.com/api/token', [
            'form_params' => [
                'grant_type' => 'client_credentials',
            ],
            'headers'     => [
                'Authorization' => "Basic " . base64_encode(self::CLIENT_ID . ':' . self::CLIENT_SECRET),
            ],
        ]);

        $data = json_decode($res->getBody(), true);

        $this->token = $data['access_token'];
        $this->dataExpiracaoToken = new DateTime();
        $this->dataExpiracaoToken->add(new DateInterval('PT' . $data['expires_in'] . 'S'));
    }

    /**
     * @return string|null
     * @throws \GuzzleHttp\Exception\GuzzleException
     */
    public function get(): ?string
    {
        $agora = new \DateTime();

        if ($this->token) {
            if ($this->dataExpiracaoToken >= $agora) {
                return $this->token;
            }
        }

        $this->setFromSpotify();

        return $this->token;
    }
}
