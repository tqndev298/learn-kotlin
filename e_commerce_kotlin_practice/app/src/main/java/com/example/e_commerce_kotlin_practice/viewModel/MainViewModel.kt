package com.example.e_commerce_kotlin_practice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_kotlin_practice.model.BrandModel
import com.example.e_commerce_kotlin_practice.model.ItemModel
import com.example.e_commerce_kotlin_practice.model.SliderModel
import com.example.e_commerce_kotlin_practice.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val brands: LiveData<MutableList<BrandModel>> = repository.brands

    val sliders: LiveData<MutableList<SliderModel>> = repository.sliders

    val popular: LiveData<MutableList<ItemModel>> = repository.popular


    fun loadBrands() = repository.loadBrands()

    fun loadSliders() = repository.loadSliders()

    fun loadPopular() = repository.loadPopular()

}