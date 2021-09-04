package org.techtown.yachu.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity
data class User(
    var name : String,
    var score : Int,
    val date: String
){
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}