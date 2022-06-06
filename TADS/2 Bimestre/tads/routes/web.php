<?php

use App\Http\Controllers\Admin\PostController;
use App\Http\Controllers\IndexController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Admin\RecadoController;
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

Route::get('/', IndexController::class)->name('home');


//Route::resource('/user',UserController::class);

Route::prefix('admin')->namespace('Admin')->group(function(){

    Route::prefix('recados')->name('recados.')->group(function(){
        Route::get('/create',[RecadoController::class,'create'])->name('create');
        Route::post('/store',[RecadoController::class,'store'])->name('store');
    });

    Route::prefix('posts')->name('posts.')->group(function(){
        Route::get('/create',[PostController::class,'create'])->name('create');
        Route::post('/store',[PostController::class,'store'])->name('store');
    });
});
