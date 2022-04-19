package com.example.netflixclone.Repository.MainRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class MainViewModelRepository : IMainViewModel {

    override fun getUsers(
        application: Application,
        listUsers: MutableLiveData<ArrayList<UserModel>>
    ) {
        val listaAux = RoomMethods(application).getUser()
        listUsers.postValue(listaAux as ArrayList<UserModel>)
    }
}