<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cadastrar Post</title>
</head>
<body>
    <form action="{{route('posts.store')}}?armazena=true" method="post">
        @csrf
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" class="form-control" value="{{old('nome')}}">
        </div>
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" class="form-control" value="{{old('email')}}">
        </div>
        <div class="form-group">
            <label for="cidade">Cidade:</label>
            <input type="text" name="cidade" id="cidade" class="form-control" value="{{old('cidade')}}">
        </div>
        <div class="form-group">
            <label for="recado">Recado:</label>
            <textarea name="recado" id="recado" cols="30" rows="10">{{old('recado')}}</textarea>
        </div>
        
        <button class="btn btn-lg btn-success">Criar</button>
    </form>
</body>
</html>