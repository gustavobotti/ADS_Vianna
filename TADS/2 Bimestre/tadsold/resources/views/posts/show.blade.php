@extends('layouts.app')

@section('title','Exibir Post: '.$post->title)

@section('content')  
    <p>
        Title: {{$post->title}}
    </p>
    <p>
        Description: {{$post->description}}
    </p>
    <p>
        Content: {{$post->content}}
    </p>
    <p>
        Slug: {{$post->slug}}
    </p>
    <p>
        User id: {{$post->user_id}}
    </p>
    <p>
        Is active: {{$post->is_active}}
    </p>

    <form action="{{route('posts.index')}}" method="get">
    <input type="submit" value="Back"></form>
@endsection