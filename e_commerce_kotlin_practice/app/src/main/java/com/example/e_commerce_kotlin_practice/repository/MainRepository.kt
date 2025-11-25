package com.example.e_commerce_kotlin_practice.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce_kotlin_practice.model.BrandModel
import com.example.e_commerce_kotlin_practice.model.ItemsModel
import com.example.e_commerce_kotlin_practice.model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _brands = MutableLiveData<MutableList<BrandModel>>()

    private val _sliders = MutableLiveData<MutableList<SliderModel>>()

    private val _popular = MutableLiveData<MutableList<ItemsModel>>()

    val brands: LiveData<MutableList<BrandModel>> get() = _brands

    val sliders: LiveData<MutableList<SliderModel>> get() = _sliders

    val popular: LiveData<MutableList<ItemsModel>> get() = _popular

    fun loadBrands() {
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BrandModel>()
                for (child in snapshot.children) {
                    val brandModel = child.getValue(BrandModel::class.java)?.let {
                        list.add(it)
                    }
                }
                _brands.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
                Log.e("FB", "Firebase error: ${error.message}")
            }
        })
    }


    fun loadSliders() {
        val ref = firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<SliderModel>()
                for (child in snapshot.children) {
                    val sliderModel = child.getValue(SliderModel::class.java)?.let {
                        list.add(it)
                    }
                }
                _sliders.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
                Log.e("FB", "Firebase error: ${error.message}")
            }
        })
    }


    fun loadPopular() {
        val ref = firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<ItemsModel>()
                for (child in snapshot.children) {
                    val itemModel = child.getValue(ItemsModel::class.java)?.let {
                        list.add(it)
                    }
                }
                _popular.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
                Log.e("FB", "Firebase error: ${error.message}")
            }
        })
    }
}