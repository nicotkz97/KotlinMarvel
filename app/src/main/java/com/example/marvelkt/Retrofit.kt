package com.example.marvelkt

import retrofit2.http.GET
import retrofit2.Call

interface Retrofit {


    @GET("film.json")
    fun getMovie(): Call<MutableList<Movie>>


}