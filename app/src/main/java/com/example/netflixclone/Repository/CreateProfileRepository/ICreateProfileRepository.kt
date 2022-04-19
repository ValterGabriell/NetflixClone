package com.example.netflixclone.Repository.CreateProfileRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

interface ICreateProfileRepository {
    fun addUser(application: Application, userModel: UserModel)
}