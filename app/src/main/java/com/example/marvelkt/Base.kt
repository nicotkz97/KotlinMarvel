package com.example.marvelkt

object Base {


    private val BASE_URL = " https://raw.githubusercontent.com/nicotkz97/Marvel/master/app/src/main/java/com/example/marvel/"

    val retrofitService : Retrofit
    get() = ClientRetrofit.getClient(BASE_URL).create(Retrofit::class.java)
}