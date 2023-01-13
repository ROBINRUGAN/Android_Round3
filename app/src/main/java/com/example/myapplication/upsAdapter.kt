package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class upsAdapter(val upList: List<ups>, val textView: TextView, val imageView: ImageView) :
    RecyclerView.Adapter<upsAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val upImage: ImageView = view.findViewById(R.id.upImage)
        val upname: TextView = view.findViewById(R.id.upName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.up_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val up = upList[position]
            Toast.makeText(parent.context, "这是${up.name}的简介,长按可进入详情页", Toast.LENGTH_SHORT).show()
            textView.text = "${up.name}" + "的主页简介，但是啥也没写qwq"
            imageView.setImageResource(up.imageId)
            if (up.name == "MEWW") {
                textView.text = "Mewlimewli的创始人(bushi)，mewww~~~"
            }
        }
        viewHolder.itemView.setOnLongClickListener {
            val position = viewHolder.bindingAdapterPosition
            val up = upList[position]
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("up.name", up.name)
            intent.putExtra("up.imageId", up.imageId)
            view.context.startActivity(intent)
            textView.text = ""
            imageView.setImageResource(0)
            false
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val up = upList[position]
        holder.upImage.setImageResource(up.imageId)
        holder.upname.text = up.name

    }

    override fun getItemCount() = upList.size

}

