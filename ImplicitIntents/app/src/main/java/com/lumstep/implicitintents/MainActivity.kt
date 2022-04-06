package com.lumstep.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {
    private lateinit var buttonWebSite: Button
    private lateinit var buttonLocation: Button
    private lateinit var buttonShare: Button
    private lateinit var buttonPhoto: Button

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonWebSite = findViewById(R.id.open_website_button)
        buttonLocation = findViewById(R.id.open_location_button)
        buttonShare = findViewById(R.id.share_text_button)
        buttonPhoto = findViewById(R.id.take_photo_button)

        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareEditText = findViewById(R.id.share_edittext)

        buttonWebSite.setOnClickListener {
            val webPage = Uri.parse(mWebsiteEditText.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, webPage)

            startImplicitIntent(intent)
        }
        buttonLocation.setOnClickListener {
            val addressUri = Uri.parse("geo:0,0?q=" + mLocationEditText.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            startImplicitIntent(intent)
        }
        buttonShare.setOnClickListener {
            ShareCompat.IntentBuilder(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(mShareEditText.text.toString())
                .startChooser()
        }
        buttonPhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startImplicitIntent(intent)
        }
    }

    private fun startImplicitIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }
}
