package com.example.e_commerce_kotlin_practice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_kotlin_practice.model.BrandModel
import com.example.e_commerce_kotlin_practice.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val brands: LiveData<MutableList<BrandModel>> = repository.brands

    fun loadBrands() = repository.loadBrands()
}