package com.example.roomdatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 4)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun contactDao() :ContactDAO

    companion object{
//        migration is used if we are switiching one version to another
        val migration3_5 = object :Migration(3,4){
            override fun migrate(database: SupportSQLiteDatabase) {

            }

        }



        @Volatile
        private var INSTANCE : ContactDataBase?=null

        fun getDatabase(context: Context):ContactDataBase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDataBase::class.java,
                        "contactDB")
                        .addMigrations(migration3_5)
                        .build()
                }

            }
            return INSTANCE!!
        }
    }


}

