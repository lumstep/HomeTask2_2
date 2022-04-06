package com.lumstep.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG_MAIN_ACTIVITY: String = "MainActivity"
const val EXTRA_MESSAGE: String = "com.lumstep.twoactivities.extra.MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonMain: Button
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG_MAIN_ACTIVITY, "-------")
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onCreate")

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val reply = it.data!!.getStringExtra(EXTRA_REPLY)

                    mReplyHeadTextView.visibility = View.VISIBLE
                    mReplyTextView.text = reply
                    mReplyTextView.visibility = View.VISIBLE
                }
            }

        buttonMain = findViewById(R.id.button_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        buttonMain.setOnClickListener {
            Log.d(LOG_TAG_MAIN_ACTIVITY, "Button clicked!")

            val message = mMessageEditText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)

            mMessageEditText.text.clear()

            getResult.launch(intent)
        }

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getCharSequence("reply_text")
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putCharSequence("reply_text", mReplyTextView.text)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG_MAIN_ACTIVITY, "onRestart")
    }
}