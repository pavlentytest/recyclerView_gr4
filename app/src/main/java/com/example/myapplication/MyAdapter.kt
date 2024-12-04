package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Item>) : RecyclerView.Adapter<MyAdapter.MyItemView>() {

    class MyItemView(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView)
        val title: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemView {
        Log.d("RRR","onCreateViewHolder()")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyItemView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyItemView, position: Int) {
        Log.d("RRR","onBindViewHolder()")
        holder.title.text = list.get(position).title
        Picasso.get().load(list.get(position).thumbnailUrl).into(holder.image)
    }
}