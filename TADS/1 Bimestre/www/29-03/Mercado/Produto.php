<?php
namespace Mercado;
abstract class Produto {
  // Properties
  private $codigo = 0;
  private $descricao = '';
  private $quantidade = 0;
  private $precoTotal = 0.0;


  // Methods
  function set_codigo(int $codigo) {
    $this->codigo = $codigo;
  }
  function get_codigo():int {
    return $this->codigo;
  }
  function set_descricao(string $descricao) {
    $this->descricao = $descricao;
  }
  function get_descricao():string {
    return $this->descricao;
  }
  function set_quantidade(int $quantidade) {
    $this->quantidade = $quantidade;
  }
  function get_quantidade():int {
    return $this->quantidade;
  }
  function set_precoTotal(float $precoTotal) {
    $this->precoTotal = $precoTotal;
  }
  function get_precoTotal():float {
    return $this->precoTotal;
  }

  abstract function imprimeEtiqueta();
}
?>
