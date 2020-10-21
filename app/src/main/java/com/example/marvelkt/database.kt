package com.example.marvelkt


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class database (context : Context) : SQLiteOpenHelper(context,dbname,factory, version){

    companion object{
        internal val dbname = "database"
        internal val factory = null;
        internal val version = 1;
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user(id integer primary key autoincrement,"+"name varchar(100), email varchar(100), password varchar(100))")

    }

    fun insertData(email:String,password:String){

        val db : SQLiteDatabase = writableDatabase
        val values : ContentValues = ContentValues()
        values.put("email",email)
        values.put("password",password)

        db.insert("user",null,values)
        db.close()

    }

    fun userPresent(email: String, password: String): Boolean {

        val db = writableDatabase
        val query = "select * from user where email = '$email' and password = '$password'"
        val cursor = db.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true;
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}




















