<?php
namespace Mercado;
class Hardware extends Produto {
  // Methods
  public function __construct(int $codigo, string $descricao, int $quantidade, float $precoTotal){
      $this->set_codigo($codigo);
      $this->set_descricao($descricao);
      $this->set_quantidade($quantidade);
      $this->set_precoTotal($precoTotal);      
  }

  public function imprimeEtiqueta()
  {
    echo "<p>";
    echo "Tipo: Hardware </br>";
    echo "Código: ".$this->get_codigo()." </br>";
    echo "Descrição: ".$this->get_descricao()." </br>";
    echo "Quantidade: ".$this->get_quantidade()." </br>";
    echo "Preço Total: ".$this->get_precoTotal()." </br>";
    echo "</p>";
  }
}
?>
