package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.Repository.CreateProfileRepository.CreateProfileRepository

class CreateProfileViewModel(
    private val createProfileRepository: CreateProfileRepository,
    application: Application
) : AndroidViewModel(application) {


    fun addUser(userModel: UserModel) {
        createProfileRepository.addUser(getApplication(), userModel)
    }

}