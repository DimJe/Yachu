package org.techtown.yachu

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
    fun cal(arr:ArrayList<Int>){

    }
    fun sum() {
        total =
            Ace + Deuces + Threes + Fours + Fives + Sixes + Choice + _4_of_a_kind + Full_House + S_straight + L_straight + Yacht
    }
}