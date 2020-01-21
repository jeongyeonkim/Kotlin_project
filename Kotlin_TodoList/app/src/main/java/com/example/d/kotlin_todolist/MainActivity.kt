package com.example.d.kotlin_todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val todo : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = arrayListOf<String>("kotlin","java")

        val todo = findViewById<ListView>(R.id.list_todo)
        todo.adapter = MainAdapter(this, item)

        val edit_todo = findViewById<EditText>(R.id.edit_todo)
        val btn_add = findViewById<Button>(R.id.btn_add)
        btn_add.setOnClickListener {
            item.add(edit_todo.text.toString())
            todo.adapter = MainAdapter(this, item)
        }
    }
}
