package com.example.e_commerce_kotlin_practice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce_kotlin_practice.model.BrandModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.xml.xpath.XPath

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _brands = MutableLiveData<MutableList<BrandModel>>()

    val brands: LiveData<MutableList<BrandModel>> get() = _brands

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
            }
        })
    }
}