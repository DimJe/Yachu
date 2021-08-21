package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import org.techtown.yachu.Players.Change_Player
import org.techtown.yachu.Players.Player

class Playing : AppCompatActivity() {
    var ImageView_list = arrayListOf<ImageView>()
    val TAG: String = "로그"
    lateinit var ReRoll: Button

    lateinit var  player : Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

        Log.d(TAG, "onCreate: called")

        val Player1_Name: String? = intent.getStringExtra("player1")
        val Player2_Name: String? = intent.getStringExtra("player2")

        var Player1 = Player(Player1_Name!!)
        var Player2 = Player(Player2_Name!!)
        player = Player1
        Player1.Ace = 5

        val _player: TextView = findViewById(R.id.Player)
        val times: TextView = findViewById(R.id.time)
        var turn: Boolean = true


        val first: ImageView = findViewById(R.id.first)
        val second: ImageView = findViewById(R.id.second)
        val third: ImageView = findViewById(R.id.third)
        val forth: ImageView = findViewById(R.id.forth)
        val fifth: ImageView = findViewById(R.id.fifth)

        val clicked_list = mutableListOf<Boolean>(false, false, false, false, false)
        ImageView_list = arrayListOf<ImageView>(first, second, third, forth, fifth)

        val table: LinearLayout = findViewById(R.id.table)
        val Ace: TableRow = findViewById(R.id.Ace)
        val Deuces: TableRow = findViewById(R.id.Deuces)
        val Threes: TableRow = findViewById(R.id.Threes)
        val Fours: TableRow = findViewById(R.id.Fours)
        val Fives: TableRow = findViewById(R.id.Fives)
        val Sixes: TableRow = findViewById(R.id.Sixes)
        val Choice: TableRow = findViewById(R.id.Choice)
        val Four_of_a_kind: TableRow = findViewById(R.id.Four_of_a_kind)
        val Full_House: TableRow = findViewById(R.id.Full_House)
        val S_Straight: TableRow = findViewById(R.id.S_Straight)
        val L_Straight: TableRow = findViewById(R.id.L_Straight)
        val Yacht: TableRow = findViewById(R.id.Yacht)

        val text : TextView = Ace.getChildAt(1) as TextView
        text.setText("1111")

        var Table_list = arrayListOf<TableRow>(
            Ace,
            Deuces,
            Threes,
            Fours,
            Fives,
            Sixes,
            Choice,
            Four_of_a_kind,
            Full_House,
            S_Straight,
            L_Straight,
            Yacht
        )

        ReRoll = findViewById(R.id.ReRoll)
        val Done: Button = findViewById(R.id.Done)

        var Roll_count: Int = 2
        times.text = times.text.toString() + Roll_count.toString()

        if (turn) _player.text = Player1_Name
        else _player.text = Player2_Name


        for (i in 0..4) {
            ImageView_list[i].setOnClickListener {
                if (!clicked_list[i]) {
                    ImageView_list[i].setBackgroundResource(R.drawable.stroke)
                    clicked_list[i] = true
                } else {
                    ImageView_list[i].setBackgroundResource(0)
                    clicked_list[i] = false
                }
            }
        }

        ReRoll.setOnClickListener {

            val arr1 = IntArray(7) { 0 }

            if (Roll_count > 0) {

                var Request_count: Int = 5

                for (i in 0..4) {
                    Log.d(TAG, " i : $i ")
                    if (clicked_list[i]) {
                        val index: Int = ImageView_list[i].tag.toString().toInt()
                        Log.d(TAG, "index: $index ")
                        arr1[index]++
                        Request_count--
                    }

                }

                arr1.forEachIndexed { index, i ->
                    Log.d(TAG, "index: $index , value : $i ")
                }

                val intent = Intent(this, random_dice::class.java)
                intent.putExtra("arr", arr1)
                intent.putExtra("request", Request_count)
                requestActivity.launch(intent)

                Log.d(TAG, "onCreate: reroll-called")
                Roll_count--
                times.text = "남은 기회 : $Roll_count"
                ReRoll.isEnabled = false
            } else {
                Log.d(TAG, "onCreate: toast-massage called")
                Toast.makeText(this, "남은 기회가 없습니다!", Toast.LENGTH_SHORT).show()
            }
        }

        Done.setOnClickListener {
            Change_Player.check(Table_list)
        }

    }

    private val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d(TAG, "onActivityResult: called")

        ReRoll.isEnabled = true

        val arr = it.data?.getIntArrayExtra("arr")
        var index = 0
        for (i in 1..6) {
            if (arr!![i] == 0) continue
            else {
                for (j in 1..arr[i]) {
                    when (i) {
                        1 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_1)
                            ImageView_list[index].tag = 1
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                        2 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_2)
                            ImageView_list[index].tag = 2
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                        3 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_3)
                            ImageView_list[index].tag = 3
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                        4 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_4)
                            ImageView_list[index].tag = 4
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                        5 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_5)
                            ImageView_list[index].tag = 5
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                        6 -> {
                            ImageView_list[index].setImageResource(R.drawable.dice_6)
                            ImageView_list[index].tag = 6
                            ImageView_list[index].setBackgroundResource(0)
                            index++
                        }
                    }
                }
            }
        }
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: called")
    }

}