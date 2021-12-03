package com.example.netflixclone.Database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.netflixclone.Entities.UserEntity
@Dao
interface UsersDAO {

    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM tabela")
    fun getUser():List<UserEntity>

    @Query("SELECT id FROM tabela")
    fun getUserId():Long

    @Query("DELETE FROM tabela WHERE id = :id")
    fun deleteUser(id:Long)

}