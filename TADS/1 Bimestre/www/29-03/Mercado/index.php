<body></body>
<?php

spl_autoload_register(
    function($class)
    {
        require_once($class.'.php');
    }
);

use Mercado\Cesta as CestaMercado;
use Pascoa\Cesta as CestaPascoa;
use Mercado\Hardware;
use Mercado\Smartphone;
use Mercado\Eletronico;

$cesta2 = new CestaPascoa;
var_dump($cesta2);

$cesta = new CestaMercado;
var_dump($cesta);
die;

$cesta -> adicionaItem(new Hardware(001, 'HD', 10, 2000));

$cesta -> adicionaItem(new Hardware(002, 'Monitor', 5, 1300));

$cesta -> adicionaItem(new Smartphone(007, 'Iphone', 2, 20000));

$cesta -> adicionaItem(new Smartphone(020, 'Motorola', 20, 2000));

$cesta -> adicionaItem(new Eletronico(021, 'Maquina de lavar', 2, 4000));

$cesta -> adicionaItem(new Eletronico(021, 'TV', 2, 2000));


$cesta->exibeLista();

echo 'Total de produtos'.$cesta->calculaTotal();

?>