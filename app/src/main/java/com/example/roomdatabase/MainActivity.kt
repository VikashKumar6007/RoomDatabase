package com.example.roomdatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var contactdatabaseclass:ContactDataBase
    lateinit var name: EditText
    lateinit var phone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.et_name)
        phone = findViewById(R.id.et_phone)

    }

    fun insert_btn(view: View) {

        var name_data = name.text.toString()
        var phone_data = phone.text.toString()

        contactdatabaseclass = ContactDataBase.getDatabase(applicationContext)

        GlobalScope.launch {
            contactdatabaseclass.contactDao().insertContact(Contact(0,name_data,
                phone_data.toLong().toString()
            ,1));
        }

    }
    fun update_with_query_btn(view: View) {

        var name_data = name.text.toString()
        var phone_data = phone.text.toString()

        contactdatabaseclass = ContactDataBase.getDatabase(applicationContext)

        GlobalScope.launch {
            contactdatabaseclass.contactDao().update_with_query(name_data,phone_data.toLong());
        }

    }

    fun delete_btn(view: View) {

        var name_data = name.text.toString()
        var phone_data = phone.text.toString()

        contactdatabaseclass = ContactDataBase.getDatabase(applicationContext)

        GlobalScope.launch {
            contactdatabaseclass.contactDao().deleteContact(Contact(11,"hi", 3456765436.toString(),1));

        }
    }

    fun delete_all_data_btn(view: View) {

        contactdatabaseclass = ContactDataBase.getDatabase(applicationContext)

        GlobalScope.launch {
            contactdatabaseclass.contactDao().deleteAllContact();
        }
    }

    fun update_btn(view: View) {

        contactdatabaseclass = ContactDataBase.getDatabase((applicationContext))

        GlobalScope.launch {
            contactdatabaseclass.contactDao().update(Contact(11,"hi", 3456765436.toString(),1))
        }
    }
}