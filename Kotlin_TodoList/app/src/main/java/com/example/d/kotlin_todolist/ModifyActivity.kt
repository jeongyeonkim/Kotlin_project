package com.example.d.kotlin_todolist

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ModifyActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        val edit_rename = findViewById<EditText>(R.id.edit_rename)
        val inputValue = intent.getStringExtra("todoText").toString()
        edit_rename.setText(inputValue)

        val btn_discard = findViewById<Button>(R.id.btn_discard)
        btn_discard.setOnClickListener {
            finish()
        }

        val btn_rename = findViewById<Button>(R.id.btn_rename)
        btn_rename.setOnClickListener {
            finish()
        }
    }
}