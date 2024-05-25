package com.example.listview.Controller.Controller

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.Controller.CustomAdapter.ProductAdapter
import com.example.listview.Controller.DataService.DataService
import com.example.listview.Controller.Utilities.EXTRA_CATEGORY
import com.example.listview.R

class Product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        For Orientation Changes
        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount =3
        }
        val product = intent.getStringExtra(EXTRA_CATEGORY)
        val ProductListView : RecyclerView = findViewById(R.id.productView)
        val adapter = ProductAdapter(this,DataService.getProduct(product.toString()))
        val layoutManager = GridLayoutManager(this,spanCount)
        ProductListView.layoutManager = layoutManager
        ProductListView.adapter = adapter

    }
}