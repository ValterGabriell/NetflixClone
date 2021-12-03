package com.example.netflixclone.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.netflixclone.Database.Dao.MyListDAO
import com.example.netflixclone.Database.Dao.UsersDAO
import com.example.netflixclone.Entities.MovieEntity
import com.example.netflixclone.Entities.UserEntity

@Database(entities = [UserEntity::class, MovieEntity::class], version = 14)
abstract class DatabaseService : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "nomeDatabase"
        private var INSTANCE: DatabaseService? = null

        private fun createDatabase(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME).fallbackToDestructiveMigration()
                .allowMainThreadQueries().build()

        fun getInstance(context: Context) : DatabaseService = (INSTANCE ?: createDatabase(context).also {
            INSTANCE = it
        })
    }

    abstract fun get() : UsersDAO
    abstract fun getMovie():MyListDAO


}