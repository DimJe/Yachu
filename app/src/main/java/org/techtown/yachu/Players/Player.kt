package org.techtown.yachu.Players

import android.graphics.Color
import android.widget.TableRow
import android.widget.TextView

class Player {
    constructor(name: String) {
        this.name = name
    }

    val name: String
    var Ace = 0
    var Deuces = 0
    var Threes = 0
    var Fours = 0
    var Fives = 0
    var Sixes = 0
    var Choice = 0
    var _4_of_a_kind = 0
    var Full_House = 0
    var S_straight = 0
    var L_straight = 0
    var Yacht = 0
    var total = 0

    val fixed_point = BooleanArray(12) { false }

    fun set(clicked: TableRow) {
        val point: Int = (clicked.getChildAt(1) as TextView).text.toString().toInt()
        val index: Int = clicked.tag.toString().toInt()
        clicked.setBackgroundColor(Color.rgb(255,255,255))
        when (index) {
            0 -> {
                this.Ace = point
                fixed_point[index] = true
            }
            1 -> {
                this.Deuces = point
                fixed_point[index] = true
            }
            2 -> {
                this.Threes = point
                fixed_point[index] = true
            }
            3 -> {
                this.Fours = point
                fixed_point[index] = true
            }
            4 -> {
                this.Fives = point
                fixed_point[index] = true
            }
            5 -> {
                this.Sixes = point
                fixed_point[index] = true
            }
            6 -> {
                this.Choice = point
                fixed_point[index] = true
            }
            7 -> {
                this._4_of_a_kind = point
                fixed_point[index] = true
            }
            8 -> {
                this.Full_House = point
                fixed_point[index] = true
            }
            9 -> {
                this.S_straight = point
                fixed_point[index] = true
            }
            10 -> {
                this.L_straight = point
                fixed_point[index] = true
            }
            11 -> {
                this.Yacht = point
                fixed_point[index] = true
            }
        }
    }


    fun sum() {
        total =
            Ace + Deuces + Threes + Fours + Fives + Sixes + Choice + _4_of_a_kind + Full_House + S_straight + L_straight + Yacht
    }
}