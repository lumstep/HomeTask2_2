package com.lumstep.shopchallenge

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

const val PRODUCT = "PRODUCT"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonAddProduct: Button
    private lateinit var buttonShowShop: Button

    private lateinit var editTextShopName:EditText

    private lateinit var textViewOne: TextView
    private lateinit var textViewTwo: TextView
    private lateinit var textViewThree: TextView
    private lateinit var textViewFour: TextView
    private lateinit var textViewFive: TextView
    private lateinit var textViewSix: TextView
    private lateinit var textViewSeven: TextView
    private lateinit var textViewEight: TextView
    private lateinit var textViewNine: TextView
    private lateinit var textViewTen: TextView

    private lateinit var listOfTextViews: List<TextView>

    private var productPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddProduct = findViewById(R.id.button_add_product)
        buttonShowShop = findViewById(R.id.button_show_shop)

        editTextShopName = findViewById(R.id.editText_shop_name)

        initTextViews()

        val getProduct =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    addProduct(it.data?.getCharSequenceExtra(PRODUCT))
                }
            }

        buttonAddProduct.setOnClickListener {
            if (productPosition == listOfTextViews.size) {
                Toast.makeText(this, "You can't add more than ten products", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ShopActivity::class.java)
                getProduct.launch(intent)
            }
        }
        buttonShowShop.setOnClickListener {
            val addressUri = Uri.parse("geo:0,0?q=" + editTextShopName.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this!")
            }
        }
    }

    private fun initTextViews() {
        textViewOne = findViewById(R.id.text_view_one)
        textViewTwo = findViewById(R.id.text_view_two)
        textViewThree = findViewById(R.id.text_view_three)
        textViewFour = findViewById(R.id.text_view_four)
        textViewFive = findViewById(R.id.text_view_five)
        textViewSix = findViewById(R.id.text_view_six)
        textViewSeven = findViewById(R.id.text_view_seven)
        textViewEight = findViewById(R.id.text_view_eight)
        textViewNine = findViewById(R.id.text_view_nine)
        textViewTen = findViewById(R.id.text_view_ten)

        listOfTextViews = listOf(
            textViewOne,
            textViewTwo,
            textViewThree,
            textViewFour,
            textViewFive,
            textViewSix,
            textViewSeven,
            textViewEight,
            textViewNine,
            textViewTen
        )
    }

    private fun addProduct(productName: CharSequence?) {
        listOfTextViews[productPosition].text = productName
        listOfTextViews[productPosition].visibility = View.VISIBLE
        productPosition++
    }
}