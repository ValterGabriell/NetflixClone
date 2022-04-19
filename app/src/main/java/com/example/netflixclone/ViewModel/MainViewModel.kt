package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.Repository.MainRepository.MainViewModelRepository

class MainViewModel(
    private val mainViewModelRepository: MainViewModelRepository,
    application: Application
) : AndroidViewModel(application) {
    val listUsers = MutableLiveData<ArrayList<UserModel>>()

    fun getUsers() {
        mainViewModelRepository.getUsers(getApplication(), listUsers)
    }

}