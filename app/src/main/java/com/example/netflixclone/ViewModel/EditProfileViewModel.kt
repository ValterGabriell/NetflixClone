package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class EditProfileViewModel(application:Application) : AndroidViewModel(application) {

     val lista = MutableLiveData<ArrayList<UserModel>>()

    fun getList(){
        val listaAux = RoomMethods(getApplication()).getUser()
        lista.postValue(listaAux as ArrayList<UserModel>)
    }

    fun deleteId(id:Long){
        RoomMethods(getApplication()).deleteUser(id)
    }



}