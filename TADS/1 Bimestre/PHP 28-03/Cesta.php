<?php
require_once 'Produto.php';
class Cesta {
  // Properties
  private $itens = Array();

  // Methods
  function set_itens($itens) {
    $this->itens = $itens;
  }

  function get_itens() {
    return $this->itens;
  }

  public function adicionaItem(Produto $produto) {
    $this->itens[] = $produto;
  }

  public function exibeLista() {
    foreach ($this->itens as $item){
        $item->imprimeEtiqueta();
    }
  }

  public function calculaTotal() {
    $total = 0.0;
    foreach($this->itens as $item){
        $total += $item->get_precoTotal();
    }
    return $total;
  }
}
?>
