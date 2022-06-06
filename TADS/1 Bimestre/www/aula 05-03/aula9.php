<?php

use DAO\AlunoDAO;

require_once "DAO\AlunoDAO.php";

$aluno = new AlunoDAO(1, 'Joaozinho');

$db = new mysqli("localhost","root","root","tads",3308);
if ($db->connect_errno > 0){
    die("Não foi possivel conectar: {$db->connect_error}");
}

$sql = 'SELECT * FROM `aluno`';

if( !$result =$db->query($sql) ){
    die("Ocorreu um erro {$db->error}");
}

echo "Total de Alunos: {$result->num_rows}<br>";
echo "Alunos: <br>";

while($aluno = $result->fetch_object('DAO\AlunoDAO'))
{
    $aluno->printData();
    
    $aluno->save($db, "Teste");
}


//while ($row = $result->fetch_assoc()) { ////fetch row, fetch array
    //var_dump($row);
//   echo $row["nome"].'<br>';
//}

$db->close();