package com.lumstep.hellotoast

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val COUNT = "COUNT_NUMBER"

class MainActivity : AppCompatActivity() {
    private lateinit var showCount: TextView
    private lateinit var buttonSayHello: Button
    private lateinit var buttonCount: Button

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCount = findViewById(R.id.show_count)
        buttonSayHello = findViewById(R.id.button_hello)
        buttonCount = findViewById(R.id.button_count)

        buttonSayHello.setOnClickListener {
            val intent = Intent(this, HelloActivity::class.java)
            intent.putExtra(COUNT, count)
            startActivity(intent)
        }
        buttonCount.setOnClickListener {
            count++
            showCount.text = count.toString()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        showCount.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

}