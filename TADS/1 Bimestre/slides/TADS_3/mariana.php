<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
    <title>Mariana Conta</title>
</head> 
<body> 
    <?php 
        for ($i = 1; $i <= 10; $i++) { ?> 
            <p>Mariana conta <?= $i ?> <br /> 
            Mariana conta <?= $i ?> 
            <?php 
                for ($j = 1; $j <= $i; $j++) { ?> 
                    é <?= $j ?>  
                <?php } ?> , <br />
            Ana viva a Mariana viva a Mariana,</p> 
        <?php } ?> 
</body> 
</html>