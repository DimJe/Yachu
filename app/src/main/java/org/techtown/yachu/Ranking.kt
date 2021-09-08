package org.techtown.yachu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var db:UserDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        db = UserDatabase.getInstance(applicationContext)!!
        var users = listOf<User>()
        CoroutineScope(Dispatchers.Main).launch {
            users = CoroutineScope(Dispatchers.IO).async {
                db.userDao().getAll()
            }.await()
        }
        val re = findViewById<RecyclerView>(R.id.re)
        re.layoutManager = LinearLayoutManager(this)

        val adapter : Adapter = Adapter(users)
        re.adapter = adapter
    }
}