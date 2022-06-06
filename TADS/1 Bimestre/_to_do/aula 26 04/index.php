<?php
function tratarErro($erro, $errstr, $file, $context)
{
    var_dump($erro, $errstr, $file, $context);
}

set_error_handler('tratarErro');

function plusOne($var = 0)
{
    if($var < 3)
    {
        trigger_error("O valor deve ser maior que 3",E_USER_ERROR);
    }

    return ++$var;
}

fopen('arquivo1','r');
echo plusOne(1);


?>