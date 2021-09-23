package org.techtown.yachu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*
import org.techtown.yachu.DataBase.User
import org.techtown.yachu.DataBase.UserDatabase

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    private lateinit var db: UserDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Yachu)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = UserDatabase.getInstance(applicationContext)!!
        val start : Button = findViewById(R.id.start)
        start.setOnClickListener {
            Log.d(TAG, "onCreate: start-clicked")
            val intent = Intent(this,Introduce_rule::class.java)
            startActivity(intent)
            finish()
        }

        val rank : Button = findViewById(R.id.ranking)
        rank.setOnClickListener {
            val intent = Intent(this,Ranking::class.java)
            startActivity(intent)
            Log.d(TAG, "ranking - clicked()")
//            CoroutineScope(Dispatchers.Main).launch {
//                var users = CoroutineScope(Dispatchers.IO).async {
//                    db.userDao().getAll()
//                }.await()
//                CoroutineScope(Dispatchers.IO).launch {
//                    if (users.isNotEmpty()){
//                        val list =  users.sortedByDescending { it.score }
//                        for (user in list) Log.d(TAG, "${user.name}  ${user.score}  ${user.date}")
//                    }
//                }
//            }
        }

    }


}