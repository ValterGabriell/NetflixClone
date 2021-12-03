package com.example.netflixclone.Entities

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.OnConflictStrategy.REPLACE
import com.example.netflixclone.Models.MyListModel

@Entity(tableName = "ListaFilmes")
class MovieEntity(


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idMovie")
    val idMovie: Int,
    @ColumnInfo(name = "idUser")
    val idUser: Long,
    @ColumnInfo(name = "titleMovie")
    val titleMovie: String,
    @ColumnInfo(name = "dateRealeased")
    val dateRealeased: String,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "foto")
    val foto: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "isThere")
    var isThere: Boolean = false
) {
    companion object {
        fun fromModelFromEntity(myListModel: MyListModel) = MovieEntity(
            myListModel.idMovie,
            myListModel.idUser,
            myListModel.titleMovie,
            myListModel.dateRealeased,
            myListModel.language,
            myListModel.foto,
            myListModel.overview,
            myListModel.isThere
        )
    }

    fun getAll() = MyListModel(
        idMovie,
        idUser,
        titleMovie,
        dateRealeased,
        language,
        foto,
        overview,
        isThere
    )
}