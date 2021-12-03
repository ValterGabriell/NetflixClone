package com.example.netflixclone.ViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.example.netflixclone.Database.RoomMethods
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Network.Model.Result
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.Network.Model.ResultXX
import com.example.netflixclone.Repository.Repository
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()



    val imgMovie = MutableLiveData<String>()
    val titleMovie = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val langague = MutableLiveData<String>()
    val sinopse = MutableLiveData<String>()
    val idFIlmePoster = MutableLiveData<Int>()


    val listaComingSoon = MutableLiveData<ArrayList<ResultX>>()
    val listaOnlyNet = MutableLiveData<ArrayList<ResultXX>>()
    val listaNewsWeek = MutableLiveData<ArrayList<Result>>()
    val listaMyList = MutableLiveData<ArrayList<MyListModel>>()


    fun getMoviesFromMyList() {
        val listaAux = RoomMethods(getApplication()).getMoviesFromMyList()
        listaMyList.postValue(listaAux as ArrayList<MyListModel>)
    }

    fun getNewsMovies(linearLayout: LinearLayout) {
        repository.getImgPosterMain(imgMovie, titleMovie, date, langague,idFIlmePoster,sinopse,linearLayout)
    }

    fun getMoviesFromDatabase(id:Int) : Boolean{
        return RoomMethods(getApplication()).getIfIsThere(id)
    }

    fun getOnlyNetflix() {
        repository.getOnlyNetflix(listaOnlyNet)
    }

    fun getUserId() : Long{
       return RoomMethods(getApplication()).getUserId()
    }

    fun getComing() {
        repository.getComing(listaComingSoon)
    }

    fun getNewsWeek() {
        repository.getNewWeek(listaNewsWeek)
    }

    fun addMovieToList(myListModel: MyListModel){
        RoomMethods(getApplication()).addMovie(myListModel)
    }
}