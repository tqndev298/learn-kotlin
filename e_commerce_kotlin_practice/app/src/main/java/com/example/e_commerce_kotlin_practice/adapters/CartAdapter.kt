package com.example.e_commerce_kotlin_practice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce_kotlin_practice.databinding.ViewholderCartBinding
import com.example.e_commerce_kotlin_practice.helpers.ChangeNumberItemsListener
import com.example.e_commerce_kotlin_practice.helpers.ManagmentCart
import com.example.e_commerce_kotlin_practice.model.ItemsModel

class CartAdapter(
    private val listItemSelected: ArrayList<ItemsModel>,
    context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener? = null,
) : RecyclerView.Adapter<CartAdapter.Viewholder>() {

    private val managmentCart = ManagmentCart(context)

    class Viewholder(val binding: ViewholderCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CartAdapter.Viewholder {
        val binding =
            ViewholderCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.Viewholder, position: Int) {
        val item = listItemSelected[position]
        holder.binding.apply {
            titleTxt.text = item.title
            feeEachItemTxt.text = "$${item.price}"
            totalEachItem.text = "$${Math.round(item.price * item.numberInCart)}"
            numberItemTxt.text = item.numberInCart.toString()


            Glide.with(holder.itemView.context).load(item.picUrl[0]).into(pic)

            plusCartBtn.setOnClickListener {
                managmentCart.plusItem(
                    listItemSelected, position, object : ChangeNumberItemsListener {
                        override fun onChanged() {
                            notifyDataSetChanged()
                            changeNumberItemsListener?.onChanged()
                        }
                    })
            }

            minusCartBtn.setOnClickListener {
                managmentCart.minusItem(
                    listItemSelected, position, object : ChangeNumberItemsListener {
                        override fun onChanged() {
                            notifyDataSetChanged()
                            changeNumberItemsListener?.onChanged()
                        }
                    })
            }
        }
    }

    override fun getItemCount(): Int = listItemSelected.size
}