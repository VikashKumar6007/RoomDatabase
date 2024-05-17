package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {
    @Insert
  suspend  fun insertContact(contact: Contact)
    @Update
    suspend fun updateContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)
    @Query("SELECT * FROM contact")
     fun getContact():LiveData<List<Contact>>
    @Query("DELETE FROM contact")
    suspend fun deleteAllContact()

    @Update()
    suspend fun update(model: Contact?)

    @Query("UPDATE contact SET name=:name,phone=:phone_number WHERE name=:name")
    suspend fun update_with_query(name:String,phone_number:Long)
}