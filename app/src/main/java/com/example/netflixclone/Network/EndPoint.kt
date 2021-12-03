package com.example.netflixclone.Network

import com.example.netflixclone.Network.Model.ComingSoon
import com.example.netflixclone.Network.Model.ModelTrailer.ModelTrailer
import com.example.netflixclone.Network.Model.ModelTrailer.Result
import com.example.netflixclone.Network.Model.OnlyNetflix
import com.example.netflixclone.Network.Model.TopRated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoint {

    @GET("top_rated?")
    fun getNewsWeek(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TopRated>


    @GET("now_playing?")
    fun getOnlyNetflix(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<OnlyNetflix>


    @GET("upcoming?")
    fun getComing(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<ComingSoon>

    @GET("{movie_id}/videos?")
    fun getTrailer(
        @Path("movie_id")movie_id:Int,
        @Query("api_key")api_key:String,
        @Query("language")language:String
    ) : Call<ModelTrailer>

}