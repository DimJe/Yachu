package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Yachu)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.start)
        start.setOnClickListener {
            Log.d(TAG, "onCreate: start-clicked")
            val intent = Intent(this,Introduce_rule::class.java)
            startActivity(intent)
            finish()
        }


    }


}