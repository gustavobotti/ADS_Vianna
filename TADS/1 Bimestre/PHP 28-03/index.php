<?php

require_once "Cesta.php";
require_once "Hardware.php";
require_once "Smartphone.php";
require_once "Eletronico.php";

$cesta = new Cesta;

$cesta -> adicionaItem(new Hardware(001, 'HD', 10, 2000));

$cesta -> adicionaItem(new Hardware(002, 'Monitor', 5, 1300));

$cesta -> adicionaItem(new Smartphone(007, 'Iphone', 2, 20000));

$cesta -> adicionaItem(new Smartphone(020, 'Motorola', 20, 2000));

$cesta -> adicionaItem(new Eletronico(021, 'Maquina de lavar', 2, 4000));

$cesta -> adicionaItem(new Eletronico(021, 'TV', 2, 2000));


$cesta->exibeLista();

echo 'Total de produtos'.$cesta->calculaTotal();

?>