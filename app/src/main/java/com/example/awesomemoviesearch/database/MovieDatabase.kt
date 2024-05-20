package com.example.awesomemoviesearch.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDAO: MovieDAO

    private lateinit var INSTANCE: MovieDatabase

    fun getDatabase(context: Context): MovieDatabase {
        synchronized(MovieDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "asteroid"
                ).build()
            }
        }
        return INSTANCE
    }
}