package com.example.ebookreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBtn = findViewById<Button>(R.id.btnAdd)
        val values = mutableListOf<String>("book1","book2","book3")
        val myListView= findViewById<ListView>(R.id.bookList)
        val adapter = ArrayAdapter<String>(this, R.layout.list_item, values)
        myListView.adapter= adapter
        myListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@MainActivity, "item clicked", Toast.LENGTH_SHORT).show()
        }

        addBtn.setOnClickListener{
            Toast.makeText(this@MainActivity, "button clicked", Toast.LENGTH_SHORT).show()
            values.add("book4")
            adapter.notifyDataSetChanged()
        }
    }
}