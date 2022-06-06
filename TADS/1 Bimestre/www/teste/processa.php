<html>
    <style>
        table, th, td {
          border:1px solid black;
        }
    </style>
<body>
    <table style="width:100%">
        <tr>
          <th>Nome</th>
          <th>Email</th>
          <th>Endereco</th>
          <th>Profissao</th>
          <th>Genero</th>
          <th>Areas de Interesse</th>
          <th>Fale conosco</th>
          <th>Recebe promocoes</th>
          <th>Senha</th>
          <th>Confirma senha</th>
        </tr>
        <tr>
          <td><?php $nome = $_POST["nome"]; retornaVazio($nome); echo ucwords(strtolower($nome)); ?></td>
          <td><?php $email = $_POST["email"]; retornaVazio($email); echo strtolower($email); ?></td>
          <td><?php $endereco = $_POST["endereco"]; retornaVazio($endereco); 
          echo ucwords(strtolower($endereco)); 
          ?></td>
          <td><?php if (isset($_POST['profissao'])){
            echo "{$_POST['profissao']}";} ?></td>
          <td><?php  if (isset($_POST['genero'])){
		  $genero = $_POST["genero"]; $outroql = $_POST["outroql"]; 
          if ($genero == 'Outro: ')
          {
            echo "$genero" . $outroql;
          } else {
            echo "$genero";
          }} else { retornaVazio(""); } 
		  ?></td>
          <td><?php if (isset($_POST['areasInteresse'])){
			  $areasInteresse = $_POST['areasInteresse'];    
                foreach($areasInteresse as $areaInteresse){
                print ($areaInteresse . " ");}
		  } else { retornaVazio(""); }
          ?></td>
          <td><?php $faleConosco = $_POST["faleConosco"]; retornaVazio($faleConosco); echo $faleConosco; ?></td>
          <td><?php if (isset($_POST['promocoes'])){
            $promocoes = $_POST["promocoes"];
			    if ($promocoes == 'Sim')
			    {
               echo "$promocoes";
			    } else {
			    echo "Nao";
			    }
        } else { retornaVazio(""); }
		?></td>
          <td><?php $senha = $_POST["senha"]; retornaVazio($senha);
			if (strlen($senha) > 6) {
				echo $senha; } else if (!empty($senha)){
				echo "Senha muito pequena";
			} 
		  ?></td>
          <td><?php $senha2 = $_POST["senha2"]; retornaVazio($senha2);
			if ($senha == $senha2){
				echo $senha; } else {
				echo "Senha diferente";
			} 
		  ?></td>
        </tr>
      </table>
</body>
</html>

<?php
	function retornaVazio($texto){
		if (empty($texto)){
			echo "Vazio";
		}
	}
?>