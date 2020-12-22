package com.example.marvelkt.Modele.API

import com.example.marvelkt.Modele.Données.Movie
import retrofit2.http.GET
import retrofit2.Call

interface Retrofit {


    @GET("film.json")
    fun getMovie(): Call<MutableList<Movie>>


}