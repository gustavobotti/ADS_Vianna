<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HelloWorldController;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('ola2',[HelloWorldController::class,'index'])->name('boas-vindas');

Route::any('teste-rota',function ()
{
    echo "Entrou na rota";
});

Route::view('boas-vindas','hello_world.index');

Route::get('post/{id}',[HelloWorldController::class,'retornaId'])->where(['id' => '[0-9]+']);

Route::prefix('avisos')->group(function(){

    Route::get('/',function ()
    { echo "index"; });

    Route::put('/criar',function ()
    {echo "criar";});

    Route::get('/exibir',function ()
    {echo "exibir";});

    Route::delete('/apagar',function ()
    {echo "apagar";});
});