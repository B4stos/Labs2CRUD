package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.labs.MainActivity


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val name = intent.getStringExtra("name")
        findViewById<TextView>(R.id.TXTGETNAME).apply { text = name }

        val ClicktoCloseBtn = findViewById<Button>(R.id.AT2BtnClose)

        ClicktoCloseBtn.setOnClickListener{
            finish()
        }
    }
}