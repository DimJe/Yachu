package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.children
import androidx.core.view.get

class Playing : AppCompatActivity() {
    var ImageView_list = arrayListOf<ImageView>()
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

        val Player1 : String? = intent.getStringExtra("player1")
        val Player2 : String? = intent.getStringExtra("player2")


        val first : ImageView = findViewById(R.id.first)
        val second : ImageView = findViewById(R.id.second)
        val third : ImageView = findViewById(R.id.third)
        val forth : ImageView = findViewById(R.id.forth)
        val fifth : ImageView = findViewById(R.id.fifth)

        var clicked_list = mutableListOf<Boolean>(false,false,false,false,false)
        ImageView_list = arrayListOf<ImageView>(first,second,third,forth,fifth)

        val table : LinearLayout = findViewById(R.id.table)
        val Ace : TableRow = findViewById(R.id.Ace)
        val Deuces : TableRow = findViewById(R.id.Deuces)
        val Threes : TableRow = findViewById(R.id.Threes)
        val Fours : TableRow = findViewById(R.id.Fours)
        val Fives : TableRow = findViewById(R.id.Fives)
        val Sixes : TableRow = findViewById(R.id.Sixes)
        val Choice : TableRow = findViewById(R.id.Choice)
        val Four_of_a_kind : TableRow = findViewById(R.id.Four_of_a_kind)
        val Full_House : TableRow = findViewById(R.id.Full_House)
        val S_Straight : TableRow = findViewById(R.id.S_Straight)
        val L_Straight : TableRow = findViewById(R.id.L_Straight)
        val Yacht : TableRow = findViewById(R.id.Yacht)

        var Table_list = arrayListOf<TableRow>(Ace,Deuces,Threes,Fours,Fives,Sixes,Choice,Four_of_a_kind,Full_House,S_Straight,L_Straight,Yacht)

        val ReRoll : Button = findViewById(R.id.ReRoll)
        val Done : Button = findViewById(R.id.Done)

        for (i in 0..4){
            ImageView_list[i].setOnClickListener {
                if (!clicked_list[i]){
                    ImageView_list[i].setBackgroundResource(R.drawable.stroke)
                    clicked_list[i] = true
                }
                else{
                    ImageView_list[i].setBackgroundResource(0)
                    clicked_list[i] = false
                }
            }
        }

        ReRoll.setOnClickListener {
            val intent = Intent(this, random_dice::class.java).apply {
                startActivityForResult(this,10)
            }
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult: called")

        var arr = data?.getIntegerArrayListExtra("arr")
        var index : Int = 0
        for (i in 1..6){
            if(arr!![i]==0) continue
            else{
                for (j in 1..arr!![i]){
                    when(i){
                        1 -> ImageView_list[index++].setImageResource(R.drawable.dice_1)
                        2 -> ImageView_list[index++].setImageResource(R.drawable.dice_2)
                        3 -> ImageView_list[index++].setImageResource(R.drawable.dice_3)
                        4 -> ImageView_list[index++].setImageResource(R.drawable.dice_4)
                        5 -> ImageView_list[index++].setImageResource(R.drawable.dice_5)
                        6 -> ImageView_list[index++].setImageResource(R.drawable.dice_6)
                    }
                }
            }
        }
    }
}