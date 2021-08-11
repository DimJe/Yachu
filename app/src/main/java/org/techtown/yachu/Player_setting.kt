package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Player_setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_setting)

        val edit1 : EditText = findViewById(R.id.player1)
        val edit2 : EditText = findViewById(R.id.player2)
        val button : Button = findViewById(R.id.setting)

        button.setOnClickListener {
            val Player1_name : String = edit1.text.toString()
            val Player2_name : String = edit2.text.toString()
            val intent = Intent(this,Playing::class.java)
            intent.putExtra("player1",Player1_name)
            intent.putExtra("player2",Player2_name)
            startActivity(intent)
            finish()
        }
    }
}