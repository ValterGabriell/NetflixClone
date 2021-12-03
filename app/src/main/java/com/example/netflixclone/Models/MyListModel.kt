package com.example.netflixclone.Models

data class MyListModel (
    val idMovie : Int,
    val idUser : Long,
    val titleMovie:String,
    val dateRealeased:String,
    val language:String,
    val foto:String,
    val overview : String,
    var isThere : Boolean = false
    )