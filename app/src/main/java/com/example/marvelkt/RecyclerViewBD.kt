package com.example.marvelkt

import AdapterMovie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewBD : AppCompatActivity(){


    lateinit var mService: Retrofit
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var  adapter : AdapterMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler)

        mService = Base.retrofitService

        recyclerView.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        getALLMovie()
    }

    fun getALLMovie(){

        mService.getMovie().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter =  AdapterMovie(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter

            }


        })

    }
}