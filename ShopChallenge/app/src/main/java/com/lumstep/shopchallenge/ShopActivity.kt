package com.lumstep.shopchallenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ShopActivity : AppCompatActivity() {
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonEight: Button
    private lateinit var buttonNine: Button
    private lateinit var buttonTen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        initButtons()
    }

    private fun initButtons(){
        val intent = Intent()

        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)
        buttonFour = findViewById(R.id.button_four)
        buttonFive = findViewById(R.id.button_five)
        buttonSix = findViewById(R.id.button_six)
        buttonSeven = findViewById(R.id.button_seven)
        buttonEight = findViewById(R.id.button_eight)
        buttonNine = findViewById(R.id.button_nine)
        buttonTen = findViewById(R.id.button_ten)

        buttonOne.setOnClickListener {
            intent.putExtra(PRODUCT,buttonOne.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonTwo.setOnClickListener {
            intent.putExtra(PRODUCT,buttonTwo.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonThree.setOnClickListener {
            intent.putExtra(PRODUCT,buttonThree.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonFour.setOnClickListener {
            intent.putExtra(PRODUCT,buttonFour.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonFive.setOnClickListener {
            intent.putExtra(PRODUCT,buttonFive.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonSix.setOnClickListener {
            intent.putExtra(PRODUCT,buttonSix.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonSeven.setOnClickListener {
            intent.putExtra(PRODUCT,buttonSeven.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonEight.setOnClickListener {
            intent.putExtra(PRODUCT,buttonEight.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonNine.setOnClickListener {
            intent.putExtra(PRODUCT,buttonNine.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        buttonTen.setOnClickListener {
            intent.putExtra(PRODUCT,buttonTen.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}