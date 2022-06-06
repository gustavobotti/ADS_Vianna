<?php

$db = new mysqli("localhost","aluno","aluno","tads",3308);
if ($db->connect_errno > 0){
    die("Não foi possivel conectar: {$db->connect_error}");
}

$sql = 'SELECT * FROM `aluno`';

if( !$result =$db->query($sql) ){
    die("Ocorreu um erro {$db->error}");
}

echo "Total de Alunos: {$result->num_rows}<br>";
echo "Alunos: <br>";
while ($row = $result->fetch_row()) { ////fetch assoc, fetch array
    var_dump($row);
    //echo $row["nome"].'<br>';
}

$db->close();