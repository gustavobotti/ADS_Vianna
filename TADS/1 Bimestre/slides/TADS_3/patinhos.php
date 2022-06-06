<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
    <title>Embedded PHP</title>
</head> 
<body> 
    <?php 
        for ($i = 99; $i >= 1; $i--) { ?> 
            <p><?= $i ?> patinhos foram passear, <br /> 
            além das montanhas para brincar. <br /> 
            A mamãe gritou: Quá, quá, quá, quá, <br /> 
            Mas só <?= $i - 1 ?> 
            patinhos voltaram de lá.</p> 
        <?php } ?> 
</body> 
</html>


