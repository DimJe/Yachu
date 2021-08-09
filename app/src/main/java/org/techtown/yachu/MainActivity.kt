package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.start)
        start.setOnClickListener {
            Log.d(TAG, "onCreate: start-clicked")
            val intent = Intent(this,random_dice::class.java)
            startActivityForResult(intent,200)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var arr = data?.getIntegerArrayListExtra("arr")
        for (i in arr!!){
            Log.d(TAG, "onActivityResult: $i")
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}