package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class Ranking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }
}