package com.emonics.kotlinrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList: ArrayList<Items> = ArrayList<Items>()
        for (i in 0..99){
            val items = Items("Item $i", (1..100).random())
            itemList.add(items)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerviewItemAdapter = RecyclerviewItemAdapter(itemList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
//        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 3)
        recyclerView.layoutManager = layoutManager
//        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = recyclerviewItemAdapter

        recyclerviewItemAdapter.setOnItemClickListener(object : ClickListener<Items>{
            override fun onClick(view: View, data: Items, position: Int) {
//                Toast.makeText(applicationContext, "Position = $position Item = ${data.name}", Toast.LENGTH_LONG).show()

                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra("VALUE", data.name)
                startActivity(intent)

            }
        })

    }
}