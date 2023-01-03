package com.emonics.kotlinrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val strValue = intent.getStringExtra("VALUE")

        Toast.makeText(applicationContext, strValue, Toast.LENGTH_LONG).show()
    }
}