package org.techtown.yachu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import java.util.*


class random_dice : AppCompatActivity() {
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_dice)
        Handler().postDelayed({
            var arr  = arrayListOf<Int>()
            for (i in 1..5){
                val random = Random()
                val x = random.nextInt(6) + 1
                arr.add(x)
                Log.d(TAG, "random: $x")
            }
            val intent = Intent(this,MainActivity::class.java)
            intent.putIntegerArrayListExtra("arr",arr)
            setResult(Activity.RESULT_OK,intent)
            finish()
        },5000)

    }

}