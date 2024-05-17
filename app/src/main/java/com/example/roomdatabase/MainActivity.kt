package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dataBase: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBase = Room.databaseBuilder(applicationContext,
        ContactDataBase::class.java,
        "contactDB").build()
        GlobalScope.launch {
            dataBase.contactDao().insertContact(Contact(0,"viaksh","564437567"))
            dataBase.contactDao().insertContact(Contact(0,"jon","564437567"))


        }


    }
}