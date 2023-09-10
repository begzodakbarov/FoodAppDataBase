package com.example.foodappdatabase1.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodappdatabase1.R
import com.example.foodappdatabase1.adapter.AdapterRv
import com.example.foodappdatabase1.databinding.FragmentListFoodragmentBinding
import com.example.foodappdatabase1.db.MyDbHelper
import com.example.foodappdatabase1.models.Food
import com.example.foodappdatabase1.utils.MyData


class ListFoodragment : Fragment(), AdapterRv.Click {
    private val binding by lazy { FragmentListFoodragmentBinding.inflate(layoutInflater) }
    private lateinit var adapter: AdapterRv
    private lateinit var myDbHalper: MyDbHelper
    private lateinit var list: ArrayList<Food>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        list = ArrayList()
        myDbHalper = MyDbHelper(binding.root.context)
        list.addAll(myDbHalper.getAllFood())
        adapter = AdapterRv(list, this)
        binding.myRv.adapter = adapter

        return binding.root
    }



    override fun onClick(food: Food) {
        MyData.food = food
        findNavController().navigate(R.id.infoFoodFragment)
    }

}