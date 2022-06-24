@extends('layouts.app')

@section('title','Lista de usuários')

@section('content')
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Posts</th>
        </tr>
        </thead>
        <tbody>
        @forelse($users as $user)
        <tr>
            <th scope="row">{{$user->id}}</th>
            <td>{{$user->name}}</td>
            <td><a href="{{route('users.posts',['user' => $user->id])}}" class="btn btn-primary">Posts</a></td>
        </tr>
        @empty
        <tr>
            <th colspan="2"> Nenhum Registro</th>
        </tr>
        @endforelse
        </tbody>
    </table>
    {{$users->links()}}
@endsection