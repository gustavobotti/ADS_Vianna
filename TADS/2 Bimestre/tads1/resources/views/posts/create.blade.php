<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cadastrar Post</title>
</head>
<body>
    <form action="{{route('posts.store')}}" method="post">
        
        @csrf

        <div class="form-group">
            <label for="title">Título:</label>
            <input type="text" name="title" id="title" class="form-control">
        </div>        
        <div class="form-group">
            <label for="title">Descrição:</label>
            <input type="text" name="description" id="description" class="form-control">
        </div>
        <div class="form-group">
            <label for="content">Conteúdo:</label>
            <textarea name="content" id="content" cols="30" rows="10"></textarea>
        </div>
        <div class="form-group">
            <label for="slug">Slug</label>
            <input type="text" name="slug" id="slug" class=form-control>
        </div>

        <button class="btn btn-lg btn-success">Criar Postagem</button>
    </form>
</body>
</html>