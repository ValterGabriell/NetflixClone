package com.example.netflixclone.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.UserModel
import com.example.netflixclone.Repository.EditProfileRepository.EditProfileRepositoryRepository

class EditProfileViewModel(
    private val editProfileRepositoryRepository: EditProfileRepositoryRepository,
    application: Application
) : AndroidViewModel(application) {

    val lista = MutableLiveData<ArrayList<UserModel>>()

    fun getList() {
        editProfileRepositoryRepository.getList(getApplication(), lista)
    }

    fun deleteId(id: Long) {
        editProfileRepositoryRepository.deleteId(getApplication(), id)
    }


}