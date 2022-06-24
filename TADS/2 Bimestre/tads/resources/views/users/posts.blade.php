@extends('layouts.app')

@section('title',"Postagens do usuário $user->name");

@section('content')  
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Show</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
            @forelse ($posts as $post)
            <tr>
                <td>{{ $post->title }}</td>
                <td>
                    <form action="{{route('posts.show',['post' => $post->id])}}" method="get">
                        <input type="submit" value="Show">
                    </form>
                </td>
                <td>
                    <form action="{{route('posts.edit',['post' => $post->id])}}" method="get">
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="{{route('posts.destroy',['post' => $post->id])}}" method="post">
                    @csrf
                    @method('DELETE')
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="4"> Nenhum registro </td>
            </tr>              
            @endforelse
    </table>    
@endsection