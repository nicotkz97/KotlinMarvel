package com.example.marvelkt.Vue

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelkt.R
import kotlinx.android.synthetic.main.activity_menu.*

class Activity_menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonMovie.setOnClickListener {
            startActivity(Intent(this, RecyclerViewBD::class.java))
        }



    }
}