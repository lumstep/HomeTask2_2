package com.lumstep.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    private lateinit var countNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        countNumber = findViewById(R.id.count_number)

        countNumber.text = intent.getIntExtra(COUNT,-1).toString()
    }
}