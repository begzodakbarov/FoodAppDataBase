package com.example.foodappdatabase1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodappdatabase1.databinding.ItemRvBinding
import com.example.foodappdatabase1.models.Food
import com.example.foodappdatabase1.screen.ListFoodragment

class AdapterRv(var list:ArrayList<Food>, val rvclick: ListFoodragment):RecyclerView.Adapter<AdapterRv.Vh>() {
    inner class Vh(var item:ItemRvBinding):ViewHolder(item.root){
        fun onBind(food: Food){
            item.txtName.text = food.nomi
            item.root.setOnClickListener {
                rvclick.onClick(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    interface Click{
        fun onClick(food: Food)
    }
}