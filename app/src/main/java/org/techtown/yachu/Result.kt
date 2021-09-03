package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.yachu.DataBase.User
import org.techtown.yachu.DataBase.UserDatabase
import org.techtown.yachu.Players.Player
import java.util.*

class Result : AppCompatActivity() {

    private lateinit var db:UserDatabase
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        db = UserDatabase.getInstance(applicationContext)!!

        val player1 : Player = intent.getSerializableExtra("player1") as Player
        val player2 : Player = intent.getSerializableExtra("player2") as Player
        var winner : Player

        val Player1_layout : LinearLayout = findViewById(R.id.Player1)
        val Player2_layout : LinearLayout = findViewById(R.id.Player2)

        (Player1_layout.getChildAt(0) as TextView).text = player1.name
        (Player1_layout.getChildAt(1) as TextView).text = player1.sum().toString()
        (Player1_layout.getChildAt(2) as TextView).text = player1.bonus().toString()
        (Player1_layout.getChildAt(3) as TextView).text = (player1.total + player1.Bonus).toString()

        (Player2_layout.getChildAt(0) as TextView).text = player2.name
        (Player2_layout.getChildAt(1) as TextView).text = player2.sum().toString()
        (Player2_layout.getChildAt(2) as TextView).text = player2.bonus().toString()
        (Player2_layout.getChildAt(3) as TextView).text = (player1.total + player1.Bonus).toString()

        if(player1.total + player1.Bonus>player2.total + player2.Bonus) winner = player1
        else winner = player2

        val insert : Button = findViewById(R.id.insert)
        insert.setOnClickListener {
            var name = winner.name
            var score = winner.total + winner.Bonus
            var date = Date()
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().insert(User(name,score,date))
            }
            Log.d(TAG, "db-insert()")
        }
    }
}