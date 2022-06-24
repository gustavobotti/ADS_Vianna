@extends('layouts.app')

@section('title','Editar Post')

@section('content')  
    <form action="{{route('posts.update',['post' => $post->id])}}" method="post">
        @csrf
        @method('PUT')
        <div class="form-group">
            <label for="title">Título:</label>
            <input type="text" name="title" id="title" class="form-control" value="{{$post->title}}">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" name="description" id="description" class="form-control" value="{{$post->description}}">
        </div>
        <div class="form-group">
            <label for="content">Conteúdo:</label>
            <textarea name="content" id="content" cols="30" rows="10">{{$post->content}}</textarea>
        </div>
        <div class="form-group">
            <label for="slug">Slug:</label>
            <input type="text" name="slug" id="slug" class="form-control" value="{{$post->slug}}">
        </div>

        <button class="btn btn-lg btn-success">Atualizar Postagem</button>
    </form>
@endsection