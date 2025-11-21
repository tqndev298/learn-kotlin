package com.example.e_commerce_kotlin_practice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce_kotlin_practice.databinding.ViewholderBrandBinding
import com.example.e_commerce_kotlin_practice.model.BrandModel

class BrandsAdapter(private val items: MutableList<BrandModel>) :
    RecyclerView.Adapter<BrandsAdapter.Viewholder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1


    fun updateData(newData: List<BrandModel>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()

    }

    class Viewholder(val binding: ViewholderBrandBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BrandsAdapter.Viewholder {
        val binding =
            ViewholderBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: BrandsAdapter.Viewholder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context).load(item.picUrl).into(holder.binding.pic)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            if (lastSelectedPosition != -1) notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        val isSelected = selectedPosition == position

        holder.binding.pic.setBackgroundResource(
            if(isSelected){
                R.drawable
            }else{

            }
        )
    }

    override fun getItemCount(): Int = items.size

}