package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Introduce_rule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce_rule)

        val introduce : Button = findViewById(R.id.introduce)
        introduce.setOnClickListener {
            val intent = Intent(this,Player_setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}