package org.techtown.yachu.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.yachu.DataBase.User
import org.techtown.yachu.R

class Adapter(val list:List<User>) : RecyclerView.Adapter<Adapter.Holder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder.name.text = list.get(position).name
        holder.score.text = list.get(position).score.toString()
        holder.date.text = list.get(position).date
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val score = itemView.findViewById<TextView>(R.id.score)
        val date = itemView.findViewById<TextView>(R.id.date)
    }
}