package com.example.e_commerce_kotlin_practice.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_kotlin_practice.R
import com.example.e_commerce_kotlin_practice.databinding.ViewholderColorBinding
import com.example.e_commerce_kotlin_practice.databinding.ViewholderSizeBinding

class SizeAdapter(private val items: ArrayList<String>) :
    RecyclerView.Adapter<SizeAdapter.Viewholder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class Viewholder(val binding: ViewholderSizeBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SizeAdapter.Viewholder {
        val binding =
            ViewholderSizeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: SizeAdapter.Viewholder, position: Int) {
        holder.binding.apply {
            sizeText.text = items[position]

            root.setOnClickListener {
                if (selectedPosition != position) {
                    lastSelectedPosition = selectedPosition
                    selectedPosition = position
                    if (lastSelectedPosition != -1) {
                        notifyItemChanged(lastSelectedPosition)
                    }
                    notifyItemChanged(selectedPosition)
                }
            }

            if (selectedPosition == position) {
                holder.binding.apply {
                    colorLayout.setBackgroundResource(R.drawable.blue_bg)
                    sizeText.setTextColor(holder.itemView.context.resources.getColor(R.color.white))

                }
            } else {
                holder.binding.apply {
                    colorLayout.setBackgroundResource(R.drawable.stroke_pink_bg)
                    sizeText.setTextColor(holder.itemView.context.resources.getColor(R.color.black))
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}