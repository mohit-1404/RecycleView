package com.example.listview.Controller.CustomAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listview.Controller.Model.Category
import com.example.listview.R

class CustomAdapter(private val context: Context, private val categories:List<Category>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        val holder:ViewHolder
        var categoryView: View

        if(convertView == null){
            holder = ViewHolder()
            categoryView = LayoutInflater.from(context).inflate(R.layout.cusotmadapterview,null)
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName= categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
        }
        else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.name
        return categoryView
    }


    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(postion: Int): Any {
        return categories[postion]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    private class ViewHolder{
        var categoryImage:ImageView? = null
        var categoryName:TextView? = null
    }
}