<?php

echo 'POST: ';
var_dump($_POST);
echo 'GET: ';
var_dump($_GET);
echo '<br>';
var_dump($_REQUEST);
echo '<br>';
echo 'O nome do usuário é '.$_GET['nome'].'<br>';
echo 'O nome do usuário é '.$_GET['sobrenome'].'<br>';