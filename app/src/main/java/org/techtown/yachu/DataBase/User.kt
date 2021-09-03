package org.techtown.yachu.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User(
    var name : String,
    var score : Int,
    var date: Date
){
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}