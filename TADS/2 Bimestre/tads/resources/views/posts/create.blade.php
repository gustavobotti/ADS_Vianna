  @extends('layouts.app')

  @section('title','Criar Post')

  @section('content')    
  <form action="{{route('posts.store')}}?armazena=true" method="post">
        @csrf
        <div class="form-group">
            <label for="title">Título:</label>
            <input type="text" name="title" id="title" class="form-control" value="{{old('title')}}">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" name="description" id="description" class="form-control" value="{{old('description')}}">
        </div>
        <div class="form-group">
            <label for="content">Conteúdo:</label>
            <textarea name="content" id="content" cols="30" rows="10">{{old('content')}}</textarea>
        </div>
        <div class="form-group">
            <label for="slug">Slug:</label>
            <input type="text" name="slug" id="slug" class="form-control" value="{{old('slug')}}">
        </div>
        
        <div class="form-group">
            <label for="user">User:</label>
            <select name="user" id="user">
                @foreach ($users as $user)
                    <option value="{{$user->id}}">{{$user->name}}</option>
                @endforeach
            </select>
        </div>


        <button class="btn btn-lg btn-success">Criar Postagem</button>
    </form>
    @endsection

