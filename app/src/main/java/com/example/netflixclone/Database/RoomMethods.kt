package com.example.netflixclone.Database

import android.content.Context
import com.example.netflixclone.Entities.MovieEntity
import com.example.netflixclone.Entities.UserEntity
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Models.UserModel

class RoomMethods(context: Context):RoomDataSource {

    private val get = DatabaseService.getInstance(context).get()
    private val getMovie = DatabaseService.getInstance(context).getMovie()

    override fun addUser(userModel: UserModel) {
        get.addUser(UserEntity.fromModelFromEntity(userModel))
    }

    override fun getUser(): List<UserModel> =
        get.getUser().map {
            it.getAll()
        }

    override fun getUserId(): Long {
        return get.getUserId()
    }


    override fun deleteUser(id: Long) {
        get.deleteUser(id)
    }

    override fun addMovie(myListModel: MyListModel) {
        getMovie.addMovie(MovieEntity.fromModelFromEntity(myListModel))
    }

    override fun getIfIsThere(id:Int): Boolean {
        return getMovie.getIsThere(id)
    }


    override fun getMoviesFromMyList(): List<MyListModel> {
        return getMovie.getMoviesList()
    }


}