package com.lumstep.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val EXTRA_REPLY = "com.lumstep.twoactivities.extra.REPLY"
const val LOG_TAG_SECOND_ACTIVITY: String = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var mReply: EditText
    private lateinit var buttonSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(LOG_TAG_SECOND_ACTIVITY, "-------")
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onCreate")

        textView = findViewById(R.id.text_message)
        mReply = findViewById(R.id.editText_second)
        buttonSecond = findViewById(R.id.button_second)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        textView.text = message

        buttonSecond.setOnClickListener{
            val reply = mReply.text.toString()

            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)

            Log.d(LOG_TAG_SECOND_ACTIVITY, "End SecondActivity")
            finish()
        }
    }



    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG_SECOND_ACTIVITY, "onRestart")
    }
}