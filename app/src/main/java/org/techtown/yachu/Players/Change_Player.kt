package org.techtown.yachu.Players

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Change_Player {
    companion object {
        fun change(_player: TextView, player: Player, table: ArrayList<TableRow>,ImageList : ArrayList<ImageView>) {

            var text: TextView
            _player.text = player.name

            text = table[0].getChildAt(1) as TextView
            text.text = player.Ace.toString()
            if(player.fixed_point[0]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[1].getChildAt(1) as TextView
            text.text = player.Deuces.toString()
            if(player.fixed_point[1]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[2].getChildAt(1) as TextView
            text.text = player.Threes.toString()
            if(player.fixed_point[2]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[3].getChildAt(1) as TextView
            text.text = player.Fours.toString()
            if(player.fixed_point[3]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[4].getChildAt(1) as TextView
            text.text = player.Fives.toString()
            if(player.fixed_point[4]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[5].getChildAt(1) as TextView
            text.text = player.Sixes.toString()
            if(player.fixed_point[5]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[6].getChildAt(1) as TextView
            text.text = player.Choice.toString()
            if(player.fixed_point[6]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[7].getChildAt(1) as TextView
            text.text = player._4_of_a_kind.toString()
            if(player.fixed_point[7]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[8].getChildAt(1) as TextView
            text.text = player.Full_House.toString()
            if(player.fixed_point[8]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[9].getChildAt(1) as TextView
            text.text = player.S_straight.toString()
            if(player.fixed_point[9]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[10].getChildAt(1) as TextView
            text.text = player.L_straight.toString()
            if(player.fixed_point[10]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            text = table[11].getChildAt(1) as TextView
            text.text = player.Yacht.toString()
            if(player.fixed_point[11]) text.setTextColor(Color.rgb(255,0,0,))
            else text.setTextColor(Color.rgb(0,0,0))

            for (i in ImageList){
                i.setImageDrawable(null)
            }
        }

        fun cal(arr: IntArray, table: ArrayList<TableRow>, player: Player) {

            var text: TextView

            if (!player.fixed_point[0]) {
                text = table[0].getChildAt(1) as TextView
                text.text = arr[1].toString()
            }

            if (!player.fixed_point[1]) {
                text = table[1].getChildAt(1) as TextView
                text.text = (arr[2] * 2).toString()
            }

            if (!player.fixed_point[2]) {
                text = table[2].getChildAt(1) as TextView
                text.text = (arr[3] * 3).toString()
            }
            if (!player.fixed_point[3]) {
                text = table[3].getChildAt(1) as TextView
                text.text = (arr[4] * 4).toString()
            }

            if (!player.fixed_point[4]) {
                text = table[4].getChildAt(1) as TextView
                text.text = (arr[5] * 5).toString()
            }

            if (!player.fixed_point[5]) {
                text = table[5].getChildAt(1) as TextView
                text.text = (arr[6] * 6).toString()
            }

            if (!player.fixed_point[6]) {
                text = table[6].getChildAt(1) as TextView
                text.text =
                    (arr[1] + arr[2] * 2 + arr[3] * 3 + arr[4] * 4 + arr[5] * 5 + arr[6] * 6).toString()
            }
            if (!player.fixed_point[7]) {
                text = table[7].getChildAt(1) as TextView
                text.text = "0"
                for (i in 1..6) {
                    if (arr[i] >= 4) {
                        text.text =
                            (arr[1] + arr[2] * 2 + arr[3] * 3 + arr[4] * 4 + arr[5] * 5 + arr[6] * 6).toString()
                        break
                    }
                }
            }
            if (!player.fixed_point[8]) {
                text = table[8].getChildAt(1) as TextView
                text.text = "0"
                for (i in 1..6) {
                    if (arr[i] == 3) {
                        for (j in 1..6) {
                            if (j == i) continue
                            else if (arr[j] == 1) break
                            else if (arr[j] == 2) {
                                text.text =
                                    (arr[1] + arr[2] * 2 + arr[3] * 3 + arr[4] * 4 + arr[5] * 5 + arr[6] * 6).toString()
                            }
                        }
                    }
                }
            }
            if (!player.fixed_point[9]) {
                text = table[9].getChildAt(1) as TextView
                text.text = "0"
                if (arr[1] >= 1 && arr[2] >= 1 && arr[3] >= 1 && arr[4] >= 1) text.text = "15"
                else if (arr[2] >= 1 && arr[3] >= 1 && arr[4] >= 1 && arr[5] >= 1) text.text = "15"
                else if (arr[3] >= 1 && arr[4] >= 1 && arr[5] >= 1 && arr[6] >= 1) text.text = "15"
            }
            if (!player.fixed_point[10]) {
                text = table[10].getChildAt(1) as TextView
                text.text = "30"
                for (i in 1..6) {
                    if (arr[i] == 1) continue
                    else text.text = "0"
                }
            }
            if (!player.fixed_point[11]) {
                text = table[11].getChildAt(1) as TextView
                text.text = "0"
                for (i in 1..6) {
                    if (arr[i] == 5) {
                        text.text = "50"
                        break
                    }
                }
            }

        }
    }
}