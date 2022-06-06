<?php

require_once "Arvore.php";

$s = new No('s',0.0);
$a = new No('a',8.1);
$b = new No('b',5.2);
$c = new No('c',4.8);
$d = new No('d',8.3);
$e = new No('e',6.4);
$f = new No('f',4.7);
$g = new No('g',2.5);
$t = new No('t',0.0);


$s->setFilhos(Array($a,$b));
$a->setFilhos(Array($b));
$b->setFilhos(Array($c,$f));
$c->setFilhos(Array($t));
$d->setFilhos(Array($e));
$e->setFilhos(Array($f));
$f->setFilhos(Array($g));
$g->setFilhos(Array($t));

$arvore = new Arvore($a);

$ordenados = $b->getOrdenados();

foreach($ordenados as $no){
    echo $no->getValor()."<br/>";
}

//echo $a->getHeuristica();



?>