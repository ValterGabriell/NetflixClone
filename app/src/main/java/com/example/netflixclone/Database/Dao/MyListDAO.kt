package com.example.netflixclone.Database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.netflixclone.Entities.MovieEntity
import com.example.netflixclone.Entities.UserEntity
import com.example.netflixclone.Models.MyListModel

@Dao
interface MyListDAO {

    @Insert
    fun addMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM ListaFilmes WHERE idMovie = :idMovie AND idUser =:idUser")
    fun deleteMovie(idMovie: Int, idUser: Long)

    @Query("SELECT isThere FROM ListaFilmes WHERE idMovie = :id")
    fun getIsThere(id:Int) : Boolean

    @Query("SELECT * FROM ListaFilmes")
    fun getMoviesList():List<MyListModel>
}