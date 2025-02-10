package com.example.saneforcedoc.repo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseBuilder {

    @Database(entities = [Doctor::class,Chemist::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun productDao(): ProductDao
        abstract fun chemistDao(): ChemistDao
    }

    private var INSTANCE: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "productDB"
        ).build()
}