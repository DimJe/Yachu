package org.techtown.yachu.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{
    @Insert
    fun insert(user : User)

    @Query("SELECT * FROM User")
    fun getAll() : List<User>

    @Delete
    fun delete(user: User)
}