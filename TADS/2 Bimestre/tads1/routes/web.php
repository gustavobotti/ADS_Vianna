<?php

use App\Http\Controllers\Admin\PostController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HelloWorldController;
use App\Http\Controllers\IndexController;
use App\Http\Controllers\UserController;

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

Route::get('/', IndexController::class);

Route::resource('/user',UserController::class);

Route::prefix('admin')->namespace('Admin')->group(function(){
    Route::prefix('posts')->name('posts.')->group(function(){
        Route::get('/create',[PostController::class,'create'])->name('create');
        Route::post('/store',[PostController::class,'store'])->name('store');
    });
});