package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class CreateProfileViewModel(application: Application) : AndroidViewModel(application) {



    fun addUser(userModel: UserModel){
        RoomMethods(getApplication()).addUser(userModel)
    }

}