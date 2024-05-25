package com.example.listview.Controller.CustomAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.Controller.Model.Category
import com.example.listview.R

    class CustomRecycleviewAdapter(private val context: Context, private val categories:List<Category> , val itemClick:(Category)->Unit) : RecyclerView.Adapter<CustomRecycleviewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.cusotmadapterview, parent, false)
        return Holder(view,itemClick)
    }

    inner class Holder(itemView: View,val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(itemView) {
        val categorieName = itemView.findViewById<TextView>(R.id.categoryName)
        val categorieImage = itemView.findViewById<ImageView>(R.id.categoryImage)

        fun bind(context: Context, categories: List<Category>, position: Int) {
            val category = categories[position]
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categorieImage.setImageResource(resourceId)
            categorieName.text = category.name
//            On Click Listener
            itemView.setOnClickListener { itemClick(category) }
        }
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, p1: Int) {
        holder.bind(context,categories,p1)
    }
}

