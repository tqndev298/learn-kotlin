package com.example.e_commerce_kotlin_practice.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_kotlin_practice.R
import com.example.e_commerce_kotlin_practice.adapters.CartAdapter
import com.example.e_commerce_kotlin_practice.databinding.ActivityCartBinding
import com.example.e_commerce_kotlin_practice.helpers.ChangeNumberItemsListener
import com.example.e_commerce_kotlin_practice.helpers.ManagmentCart

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managmentCart = ManagmentCart(this)

        initView()
        calculatorCart()
        initCartList()
    }

    private fun initCartList() {
        binding.apply {
            viewCart.layoutManager =
                LinearLayoutManager(this@CartActivity, LinearLayoutManager.VERTICAL, false)
            viewCart.adapter = CartAdapter(
                managmentCart.getListCart(), this@CartActivity, object : ChangeNumberItemsListener {
                    override fun onChanged() {
                        calculatorCart()
                    }

                })
            if (managmentCart.getListCart().isEmpty) {
                emptyTxt.visibility = View.VISIBLE
                viewCart.visibility = View.GONE
            } else {
                emptyTxt.visibility = View.GONE
                viewCart.visibility = View.VISIBLE
            }
        }
    }

    private fun initView() {
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun calculatorCart() {
        val percentTax = 0.02
        val delivery = 10.0
        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100) / 100.0
        val total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100.0
        val itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100.0

        binding.apply {
            totalFeeTxt.text = "$$itemTotal"
            taxTxt.text = "$$tax"
            totalTxt.text = "$$total"
        }
    }


}