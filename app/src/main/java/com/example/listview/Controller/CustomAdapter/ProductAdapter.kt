package com.example.listview.Controller.CustomAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.Controller.Model.Product
import com.example.listview.R

class ProductAdapter(val context: Context, val product:List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):  ProductAdapter.ProductHolder {
       return ProductHolder(LayoutInflater.from(context).inflate(R.layout.product_list,parent,false))
    }


    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.productimage)
        val name = itemView.findViewById<TextView>(R.id.productname)
        val price = itemView.findViewById<TextView>(R.id.productprice)

        fun productBind(context: Context, product: List<Product>,position: Int){
            val pr = product[position]
            val resourceId = context.resources.getIdentifier(pr.image,"drawable",context.packageName)
            image.setImageResource(resourceId)
            name.text =  pr.name
            price.text = pr.amount
        }

    }



    override fun onBindViewHolder(holder: ProductAdapter.ProductHolder, position: Int) {
        holder.productBind(context,product,position)
    }

    override fun getItemCount(): Int {
        return product.count()
    }
}