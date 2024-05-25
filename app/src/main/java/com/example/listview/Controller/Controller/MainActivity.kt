package com.example.listview.Controller.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.Controller.CustomAdapter.CustomAdapter
import com.example.listview.Controller.CustomAdapter.CustomRecycleviewAdapter
import com.example.listview.Controller.DataService.DataService
import com.example.listview.Controller.Model.Category
import com.example.listview.Controller.Utilities.EXTRA_CATEGORY
import com.example.listview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        For a List View
//        val categoryListView: ListView = findViewById(R.id.categoryListView)
//        val adapter = CustomAdapter(this,DataService.categories)
//        categoryListView.adapter = adapter

//        For a Recycle View
        val categoryView : RecyclerView = findViewById(R.id.categoryListView)
        val adapter = CustomRecycleviewAdapter(this,DataService.categories){
            category->
            val productIntent = Intent(this,Product::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.name)
            startActivity(productIntent)
        }
        categoryView.adapter = adapter
        var layoutManager = LinearLayoutManager(this)
        categoryView.layoutManager = layoutManager
        categoryView.setHasFixedSize(true)

    }
}