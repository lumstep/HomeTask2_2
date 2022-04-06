package com.lumstep.twoactivitieschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textTitle: TextView
    private lateinit var article: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textTitle =findViewById(R.id.title)
        article =findViewById(R.id.text)

        val text = when (intent.getIntExtra(BUTTON_NUMBER, -1)) {
            1 -> {
                textTitle.text = resources.getString(R.string.button_one_title)
                article.text = resources.getString(R.string.text_one)
            }
            2 -> {
                textTitle.text = resources.getString(R.string.button_two_title)
                article.text = resources.getString(R.string.text_two)
            }
            3 -> {
                textTitle.text = resources.getString(R.string.button_three_title)
                article.text = resources.getString(R.string.text_three)
            }

            else -> {
                throw RuntimeException("Incorrect number of button")
            }
        }
    }
}