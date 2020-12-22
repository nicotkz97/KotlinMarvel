package com.example.marvelkt.VueModele

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.marvelkt.Vue.Activity_menu
import com.example.marvelkt.R
import com.example.marvelkt.Modele.Données.database
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.register.*

class MainActivity : AppCompatActivity() {

    lateinit var yaa: database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yaa = database(this)

        showHome()
        buttonRegister.setOnClickListener {
            showRegistration()
        }

        ButtonLogin.setOnClickListener {
            showLogIN()
        }


        register.setOnClickListener {
            yaa.insertData(email.text.toString(),password_register.text.toString() )
            showHome()
        }

        login.setOnClickListener {
            if( yaa.userPresent(email_login.text.toString(),password_login.text.toString() )){


                startActivity( Intent(this, Activity_menu::class.java))
            }
            else{

                //RIEN XD
            }

        }



    }
     fun showRegistration(){
        registration_layout.visibility= View.VISIBLE
        login_layout.visibility= View.GONE
        home.visibility= View.GONE
    }

     fun showLogIN(){
        registration_layout.visibility= View.GONE
        login_layout.visibility= View.VISIBLE
        home.visibility= View.GONE
    }
     fun showHome(){
        registration_layout.visibility= View.GONE
        login_layout.visibility= View.GONE
        home.visibility= View.VISIBLE
    }


}