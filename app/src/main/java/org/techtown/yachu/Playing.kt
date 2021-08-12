package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Playing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

        val first : ImageView = findViewById(R.id.first)
        val second : ImageView = findViewById(R.id.second)
        val third : ImageView = findViewById(R.id.third)
        val forth : ImageView = findViewById(R.id.forth)
        val fifth : ImageView = findViewById(R.id.fifth)

        var clicked_list = mutableListOf<Boolean>(false,false,false,false,false)
        var ImageView_list = arrayListOf<ImageView>(first,second,third,forth,fifth)

        for (i in 0..4){
            ImageView_list[i].setOnClickListener {
                if (!clicked_list[i]){
                    ImageView_list[i].setBackgroundResource(R.drawable.stroke)
                    clicked_list[i] = true
                }
                else{
                    ImageView_list[i].setBackgroundResource(0)
                    clicked_list[i] = false
                }
            }
        }

    }
}