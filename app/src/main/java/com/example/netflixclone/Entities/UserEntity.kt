package com.example.netflixclone.Entities

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.netflixclone.Models.UserModel
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Tabela")
class UserEntity (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    @ColumnInfo(name = "username")
    val username : String,
    @ColumnInfo(name = "img")
    val img: Int,
    @ColumnInfo(name = "isChild")
    val isChild : Boolean
        ){
    companion object{
        fun fromModelFromEntity(userModel: UserModel) = UserEntity(
            userModel.id, userModel.username, userModel.img, userModel.isChild
        )
    }

    fun getAll() = UserModel(id, username, img, isChild)
}