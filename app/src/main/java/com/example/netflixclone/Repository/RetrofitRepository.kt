package com.example.netflixclone.Repository

import android.content.Context
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Network.Model.Result
import com.example.netflixclone.Network.Model.ResultX
import com.example.netflixclone.Network.Model.ResultXX
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

interface RetrofitRepository {

    fun getImgPosterMain(
        img: MutableLiveData<String>,
        title: MutableLiveData<String>,
        date: MutableLiveData<String>,
        langague: MutableLiveData<String>,
        id : MutableLiveData<Int>,
        over : MutableLiveData<String>,
        linearLayout: LinearLayout
    )

    fun getOnlyNetflix(listaOnlyNet: MutableLiveData<ArrayList<ResultXX>>)

    fun getComing(listaComingSoon: MutableLiveData<ArrayList<ResultX>>)

    fun getNewWeek(listanewsWeek: MutableLiveData<ArrayList<Result>>)

}