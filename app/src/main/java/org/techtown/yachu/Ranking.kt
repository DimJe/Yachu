package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.techtown.yachu.DataBase.User
import org.techtown.yachu.DataBase.UserDatabase
import org.techtown.yachu.RecyclerView.Adapter

class Ranking : AppCompatActivity() {
    private lateinit var db: UserDatabase
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_ranking)
        Log.d(TAG, "onCreate: db")
        db = UserDatabase.getInstance(applicationContext)!!
        Log.d(TAG, "Ranking--open")
        val re = findViewById<RecyclerView>(R.id.re)
        re.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        CoroutineScope(Dispatchers.Main).launch {
            var users = CoroutineScope(Dispatchers.IO).async {
                db.userDao().getAll()
            }.await()
            users = users.sortedByDescending { it.score }
            val adapter: Adapter = Adapter(users)
            re.adapter = adapter
        }
    }
}