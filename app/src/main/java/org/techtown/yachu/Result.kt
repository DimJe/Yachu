package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.techtown.yachu.DataBase.User
import org.techtown.yachu.DataBase.UserDatabase
import org.techtown.yachu.Players.Player
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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
        val winner_text : TextView = findViewById(R.id.winner_text)
        val insert : Button = findViewById(R.id.insert)
        val replay : Button = findViewById(R.id.replay)
        val end_game : Button = findViewById(R.id.finish)

        (Player1_layout.getChildAt(0) as TextView).text = player1.name
        (Player1_layout.getChildAt(1) as TextView).text = player1.sum().toString()
        (Player1_layout.getChildAt(2) as TextView).text = player1.bonus().toString()
        (Player1_layout.getChildAt(3) as TextView).text = (player1.total + player1.Bonus).toString()

        (Player2_layout.getChildAt(0) as TextView).text = player2.name
        (Player2_layout.getChildAt(1) as TextView).text = player2.sum().toString()
        (Player2_layout.getChildAt(2) as TextView).text = player2.bonus().toString()
        (Player2_layout.getChildAt(3) as TextView).text = (player2.total + player2.Bonus).toString()

        if(player1.total + player1.Bonus>player2.total + player2.Bonus) winner = player1
        else winner = player2

        winner_text.text = "승자는 " + winner.name + "입니다!"


        insert.setOnClickListener {
            var name = winner.name
            var score = winner.total + winner.Bonus
            val current : LocalDateTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ISO_DATE
            val formatted = current.format(formatter)
            CoroutineScope(Dispatchers.Main).launch {
                val users = CoroutineScope(Dispatchers.IO).async {
                    db.userDao().getAll()
                }.await()
                CoroutineScope(Dispatchers.IO).launch {
                    if(users.size==10){
                        val list = users.sortedByDescending { it.score }
                        db.userDao().delete(list[9])
                        db.userDao().insert(User(name,score,formatted))
                        Log.d(TAG, "db - deleted() ")
                    }
                    else db.userDao().insert(User(name,score,formatted))
                }
            }
            Log.d(TAG, "db-insert() ,$score , $formatted")
            Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
        }

        replay.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        end_game.setOnClickListener {
            Log.d(TAG, "app-finished()")
            moveTaskToBack(true)
            finishAndRemoveTask()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}