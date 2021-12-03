package com.example.netflixclone.Database

import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Models.UserModel

interface RoomDataSource {
    fun addUser(userModel: UserModel)

    fun getUser(): List<UserModel>

    fun getUserId(): Long

    fun deleteUser(id: Long)

    fun addMovie(myListModel: MyListModel)

    fun getIfIsThere(id:Int): Boolean

    fun getMoviesFromMyList():List<MyListModel>

}