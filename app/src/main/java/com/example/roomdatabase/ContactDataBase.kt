package com.example.roomdatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun contactDao() :ContactDAO

    companion object{
//        migration is used if we are switiching one version to another
        val migration1_2 = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
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
                        .addMigrations(migration1_2)
                        .build()
                }

            }
            return INSTANCE!!
        }
    }


}

