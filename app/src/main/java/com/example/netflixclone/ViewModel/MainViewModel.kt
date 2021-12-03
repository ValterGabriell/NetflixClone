package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class MainViewModel(application: Application):AndroidViewModel(application) {

    val listUsers = MutableLiveData<ArrayList<UserModel>>()

    fun getUsers(){
        val listaAux = RoomMethods(getApplication()).getUser()
        listUsers.postValue(listaAux as ArrayList<UserModel>)
    }

}