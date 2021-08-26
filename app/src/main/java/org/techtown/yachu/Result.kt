package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import org.techtown.yachu.Players.Player

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val player1 : Player = intent.getSerializableExtra("player1") as Player
        val player2 : Player = intent.getSerializableExtra("player2") as Player

        val Player1_layout : LinearLayout = findViewById(R.id.Player1)
        val Player2_layout : LinearLayout = findViewById(R.id.Player2)

        (Player1_layout.getChildAt(0) as TextView).text = player1.name
        (Player1_layout.getChildAt(1) as TextView).text = player1.sum().toString()
        (Player1_layout.getChildAt(2) as TextView).text = player1.bonus().toString()
        (Player1_layout.getChildAt(3) as TextView).text = (player1.total + player1.Bonus).toString()


    }
}