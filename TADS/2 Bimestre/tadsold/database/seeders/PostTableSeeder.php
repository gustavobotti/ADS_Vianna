<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class PostTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('posts')->insert([
            'title' => 'Primeira Postagem',
            'description' => 'Descrição primeira postagem',
            'content' => 'Conteudo primeira postagem',
            'is_active' => 1,
            'slug' => 'primeira_postagem',
            'user_id' => 1
        ]);
    }
}
