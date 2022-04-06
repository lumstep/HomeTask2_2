package com.lumstep.twoactivitieschallenge

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG: String = "MainActivity"
const val BUTTON_NUMBER: String = "com.lumstep.twoactivities.extra.BUTTON"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)

        val intent = Intent(this, SecondActivity::class.java)

        buttonOne.setOnClickListener {
            Log.d(LOG_TAG, "Button one clicked!")
            intent.putExtra(BUTTON_NUMBER, 1)
            startActivity(intent)
        }
        buttonTwo.setOnClickListener {
            Log.d(LOG_TAG, "Button two clicked!")
            intent.putExtra(BUTTON_NUMBER, 2)
            startActivity(intent)
        }
        buttonThree.setOnClickListener {
            Log.d(LOG_TAG, "Button three clicked!")
            intent.putExtra(BUTTON_NUMBER, 3)
            startActivity(intent)
        }
    }
}