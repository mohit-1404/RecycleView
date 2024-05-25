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

class CustomRecycleviewAdapter(
    private val context: Context,
    private val categories: List<Category>,
    private val itemClick: (Category) -> Unit
) : RecyclerView.Adapter<CustomRecycleviewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.cusotmadapterview, parent, false)
        return Holder(view)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        private val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)

        fun bind(category: Category) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.name

            itemView.setOnClickListener { itemClick(category) }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(categories[position])
    }
}
