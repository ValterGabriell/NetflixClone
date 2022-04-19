package com.example.netflixclone.Repository.EditProfileRepository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel

class EditProfileRepositoryRepository : IEditProfileRepository {

    override fun getList(application: Application, lista: MutableLiveData<ArrayList<UserModel>>) {
        val listaAux = RoomMethods(application).getUser()
        lista.postValue(listaAux as ArrayList<UserModel>)
    }

    override fun deleteId(application: Application, id: Long) {
        RoomMethods(application).deleteUser(id)
    }


}