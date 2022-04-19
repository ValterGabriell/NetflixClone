package com.example.netflixclone.Repository.MainViewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Models.UserModel

interface IMainViewModel {
    fun getUsers(application: Application, listUsers: MutableLiveData<ArrayList<UserModel>>)

}