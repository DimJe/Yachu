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
            val arr : IntArray? = intent.getIntArrayExtra("arr")
            Log.d(TAG, " size:${arr!!.size} ")
            arr!!.forEachIndexed { index, i ->
                Log.d(TAG, "index: $index , value : $i ")
            }
            val Request_count :Int = intent.getIntExtra("request",5)
            Log.d(TAG, "count: $Request_count ")
            for (i in 0 until Request_count){
                val random = Random()
                val x = random.nextInt(6) + 1
                arr!![x]++
                Log.d(TAG, "random: $x")
            }
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("arr",arr)
            setResult(Activity.RESULT_OK,intent)
            finish()
        },5000)

    }

}