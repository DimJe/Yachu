package org.techtown.yachu.Players

import android.content.Context
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Change_Player {
    companion object{
        fun change(_player:TextView,player : Player,table : ArrayList<TableRow>){

            var text : TextView
            _player.text = player.name
            
            text = table[0].getChildAt(1) as TextView
            text.text = player.Ace.toString()

            text = table[1].getChildAt(1) as TextView
            text.text = player.Deuces.toString()

            text = table[2].getChildAt(1) as TextView
            text.text = player.Threes.toString()

            text = table[3].getChildAt(1) as TextView
            text.text = player.Fours.toString()

            text = table[4].getChildAt(1) as TextView
            text.text = player.Fives.toString()

            text = table[5].getChildAt(1) as TextView
            text.text = player.Sixes.toString()

            text = table[6].getChildAt(1) as TextView
            text.text = player.Choice.toString()

            text = table[7].getChildAt(1) as TextView
            text.text = player._4_of_a_kind.toString()

            text = table[8].getChildAt(1) as TextView
            text.text = player.Full_House.toString()

            text = table[9].getChildAt(1) as TextView
            text.text = player.S_straight.toString()

            text = table[10].getChildAt(1) as TextView
            text.text = player.L_straight.toString()

            text = table[11].getChildAt(1) as TextView
            text.text = player.Yacht.toString()
        }
    }
}