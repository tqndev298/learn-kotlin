package com.example.e_commerce_kotlin_practice.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.e_commerce_kotlin_practice.R
import com.example.e_commerce_kotlin_practice.adapters.ColorAdapter
import com.example.e_commerce_kotlin_practice.adapters.SizeAdapter
import com.example.e_commerce_kotlin_practice.databinding.ActivityDetailBinding
import com.example.e_commerce_kotlin_practice.helpers.ManagmentCart
import com.example.e_commerce_kotlin_practice.model.ItemsModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)
        item = intent.getSerializableExtra("object")!! as ItemsModel


        setupViews()
        setupSizeList()
        setupColorList()

    }

    private fun setupColorList() {
        binding.apply {
            colorList.adapter = ColorAdapter(item.color)
            colorList.layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupSizeList() {
        val sizeList = item.size.map { it }
        binding.sizeList.apply {
            adapter = SizeAdapter(sizeList as ArrayList<String>)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupViews() = with(binding) {
        titleTxt.text = item.title
        descriptionTxt.text = item.description
        priceTxt.text = "$${item.price}"
        numberItemTxt.text = item.numberInCart.toString()
        updateTotalPrice()

        Glide.with(this@DetailActivity).load(item.picUrl.firstOrNull()).into(picMain)
        backBtn.setOnClickListener { finish() }

        plusBtn.setOnClickListener {
            item.numberInCart++
            numberItemTxt.text = item.numberInCart.toString()
            updateTotalPrice()
        }

        minusBtn.setOnClickListener {
            if (item.numberInCart > 1) {
                item.numberInCart--
                numberItemTxt.text = item.numberInCart.toString()
                updateTotalPrice()
            }
        }

        addToCartBtn.setOnClickListener {
            managmentCart.insertFood(item)
        }
    }

    private fun updateTotalPrice() = with(binding) {
        totalPriceTxt.text = "$${item.price * item.numberInCart}"
    }
}