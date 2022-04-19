package com.example.netflixclone.Repository.EditProfileRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Models.UserModel

interface IEditProfileRepository {
    fun getList(application: Application, lista: MutableLiveData<ArrayList<UserModel>>)

    fun deleteId(application: Application, id: Long)


}