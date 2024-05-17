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
        dataBase = ContactDataBase.getDatabase(this)
        GlobalScope.launch {
            dataBase.contactDao().insertContact(Contact(0,"rohan","564437567",1))


        }
    }
}