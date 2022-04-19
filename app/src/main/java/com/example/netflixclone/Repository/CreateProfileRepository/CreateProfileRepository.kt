package com.example.netflixclone.Repository.CreateProfileRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class CreateProfileRepository : ICreateProfileRepository {
    override fun addUser(application: Application, userModel: UserModel) {
        RoomMethods(application).addUser(userModel)
    }


}