<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class PostController extends Controller
{
    public function create()
    {
        return view('posts.create');
    }

    public function store(Request $request)
    {
        if ($request->has('title')){ /* Armazena os dados */
            //dd($request->query('armazena'));
            //dd($request->except('title'));
            //dd($request->only('title', 'slug'));
            //dd($request->title);
            //return response("Retorno do request", 200);
            //return redirect()->route('posts.create');
            return back()->withInput();
        }
        //dd($request->input('title'));
        //dd($request->all());
    }
}
