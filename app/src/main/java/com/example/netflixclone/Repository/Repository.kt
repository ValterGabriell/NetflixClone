package com.example.netflixclone.Repository

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.netflixclone.Models.MyListModel
import com.example.netflixclone.Network.EndPoint
import com.example.netflixclone.Network.Model.*
import com.example.netflixclone.Network.Model.ModelTrailer.ModelTrailer
import com.example.netflixclone.Network.NetworkURL
import com.example.netflixclone.Network.RetrofitConfig
import com.example.netflixclone.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class Repository : RetrofitRepository {

    private val retrofit = RetrofitConfig.getRetrofitInstance(NetworkURL.URL_BASE)
    private val endPoint = retrofit.create(EndPoint::class.java)
    private val random = Random().nextInt(20)


    override fun getImgPosterMain(
        img: MutableLiveData<String>,
        title: MutableLiveData<String>,
        dates: MutableLiveData<String>,
        langaue: MutableLiveData<String>,
        idFilmePoster:MutableLiveData<Int>,
        overview:MutableLiveData<String>,
        linearLayout: LinearLayout
    ) {

        val callback =
            endPoint.getNewsWeek(NetworkURL.APP_MOVIE_KEY, NetworkURL.LANGUAGE_PT_BR, random)
        callback.enqueue(object : Callback<TopRated> {
            override fun onResponse(call: Call<TopRated>, response: Response<TopRated>) {
                response.body()?.let {
                    val random = Random().nextInt(10)
                    val imgWeb = response.body()?.results!![random].poster_path
                    val nameMovie = response.body()?.results!![random].title
                    val lingua = response.body()?.results!![random].original_language
                    val date = response.body()?.results!![random].release_date
                    val overviews = response.body()?.results!![random].overview
                    val id= response.body()?.results!![random].id

                    img.postValue("https://image.tmdb.org/t/p/w185//$imgWeb")
                    title.postValue(nameMovie)
                    dates.postValue(date)
                    langaue.postValue(lingua)
                    idFilmePoster.postValue(id)
                    overview.postValue(overviews)
                    linearLayout.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<TopRated>, t: Throwable) {
                Log.i("newsWeek", t.message.toString())
            }
        })
    }


    override fun getOnlyNetflix(listaOnlyNet: MutableLiveData<ArrayList<ResultXX>>) {
        val callback = endPoint.getOnlyNetflix(NetworkURL.APP_MOVIE_KEY, "pt-BR", random)
        callback.enqueue(object : Callback<OnlyNetflix> {
            override fun onResponse(call: Call<OnlyNetflix>, response: Response<OnlyNetflix>) {
                response.body()?.let {
                    val listaAux = it.results
                    listaOnlyNet.postValue(listaAux as ArrayList<ResultXX>)
                }

            }

            override fun onFailure(call: Call<OnlyNetflix>, t: Throwable) {
                Log.i("newsWeek", t.message.toString())
            }
        })
    }

    override fun getComing(listaComingSoon: MutableLiveData<ArrayList<ResultX>>) {
        val callback = endPoint.getComing(NetworkURL.APP_MOVIE_KEY, "pt-BR", random)
        callback.enqueue(object : Callback<ComingSoon> {
            override fun onResponse(call: Call<ComingSoon>, response: Response<ComingSoon>) {
                response.body()?.let {
                    val listaAux = it.results
                    listaComingSoon.postValue(listaAux as ArrayList<ResultX>)
                }
            }

            override fun onFailure(call: Call<ComingSoon>, t: Throwable) {
                Log.i("newsWeek", t.message.toString())
            }
        })
    }

    override fun getNewWeek(listanewsWeek: MutableLiveData<ArrayList<Result>>) {
        val callback =
            endPoint.getNewsWeek(NetworkURL.APP_MOVIE_KEY, NetworkURL.LANGUAGE_PT_BR, random)
        callback.enqueue(object : Callback<TopRated> {
            override fun onResponse(call: Call<TopRated>, response: Response<TopRated>) {
                response.body()?.let {
                    val listaAux = it.results
                    listanewsWeek.postValue(listaAux as ArrayList<Result>)
                }
            }

            override fun onFailure(call: Call<TopRated>, t: Throwable) {
                Log.i("newsWeek", t.message.toString())
            }
        })
    }

}