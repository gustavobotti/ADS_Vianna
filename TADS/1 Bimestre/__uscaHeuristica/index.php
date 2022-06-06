<?php
require_once "Cidade.php";
require_once "Custo.php";
require_once "Vizinho.php";


$graph = Array(); //array das cidades
$finalizado = false;
$aberto = Array();
$fechado = Array();
$cidadeFinal = '';
$caminhoFinal = '';
$nivel = 0;

array_push($graph, new Cidade('A',30, array(new Vizinho('B',12), new Vizinho('C',14)))); //populando graph
array_push($graph, new Cidade('B',26, array(new Vizinho('C',9), new Vizinho('D',38))));
array_push($graph, new Cidade('C',21, array(new Vizinho('D',24), new Vizinho('E',7))));
array_push($graph, new Cidade('D',7, array(new Vizinho('G',9))));
array_push($graph, new Cidade('E',22, array(new Vizinho('D',13), new Vizinho('F',9), new Vizinho('G',29))));
array_push($graph, new Cidade('F',36, null));
array_push($graph, new Cidade('G',0, null));


array_push($aberto, new Custo('', $graph[0]->getCidade(), 0, 0, ($graph[0]->getValor()))); //inicializando nós abertos
$cidadeFinal = $graph[count($graph) - 1]->getCidade();


if(!$finalizado)
{
  if($aberto[0]->getCidade() != $cidadeFinal) //chegou no objetivo?
  { 
      $custoTemp = $aberto[0];
      array_push($fechado, $aberto[0]); // passando primeiro elemento para os fechados, e removendo ele do aberto
      array_shift($aberto);

      $key = array_search($custoTemp->getCidade(), $graph); // ponteiro

      if ($graph[$key]->getVizinhos() != null) // cidade atual tem vizinhos?
      {
        foreach($graph[$key]->getVizinhos() as $vizinho)
        {
          $keyVizinho = array_search($vizinho->getCidade(), $graph); // ponteiro vizinho, para pegar seu valor heuristico      
          $temp1 = $custoTemp->getCusto() + $vizinho->getAresta();
          $temp2 = $temp1 + $graph[$keyVizinho]->getValor();

          array_push($aberto, new Custo($custoTemp->getCidade(), $vizinho->getCidade(), $vizinho->getAresta(), $temp1, $temp2));
        }

        ksort($aberto);
      }
      else
      {
        // não tem vizinhos
      }
      var_dump($aberto);
      echo $custoTemp->getCidade();
      $nivel += 1;
  } 
  else // nao ta caindo aqui... esta entrando num loop no caminho, escolhendo A->B->C->B->C->B->C->B->C->B->C->B->C->B->C->B->C->B->C->...
  {
    array_push($fechado, $aberto[0]);
    array_shift($aberto);

    $caminho = Array();
    $ponteiro = count($fechado) - 1;
    array_push($caminho, $fechado[$ponteiro]);

    while($fechado[$ponteiro]->getUltimo() != '')
    {
      $keyCusto = array_search($fechado[$ponteiro]->getUltimo(), $fechado);
      
      $ponteiro = $keyCusto;

      array_push($caminho, $fechado[$ponteiro]);
    }
    ksort($caminho);
    for ($i = 0; $i < count($caminho); $i++)
    {
      if ($i != (count($caminho) - 1))
      {
        $caminhoFinal += $caminho[$i]->getCidade() + " - ";
      }
      else
      {
        $caminhoFinal += $caminho[$i]->getCidade();
      }
    }
    
    $finalizado = true;
    echo $caminhoFinal;
  }
}

/*

$h = new No('H');
$i = new No('I');
$j = new No('J');
$k = new No('K');
    Essa é a árvore em questão:

        7
    3       12
  8  99    5  6

*/

?>