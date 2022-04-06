package com.lumstep.counterhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var showCount: TextView
    private lateinit var buttonCount: Button
    private lateinit var editText: EditText

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCount = findViewById(R.id.show_count)
        buttonCount = findViewById(R.id.button_count)
        editText = findViewById(R.id.editText)

        buttonCount.setOnClickListener {
            count++
            showCount.text = count.toString()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onResume() {
        super.onResume()
        showCount.text = count.toString()
    }
}