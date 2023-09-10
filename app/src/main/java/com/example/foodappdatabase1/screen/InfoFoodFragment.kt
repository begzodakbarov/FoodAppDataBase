package com.example.foodappdatabase1.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodappdatabase1.R
import com.example.foodappdatabase1.databinding.FragmentHomeBinding
import com.example.foodappdatabase1.databinding.FragmentInfoFoodBinding
import com.example.foodappdatabase1.utils.MyData


class InfoFoodFragment : Fragment() {
    private val binding by lazy { FragmentInfoFoodBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.txtName.text = MyData.food!!.nomi
        binding.txtFoodProduct.text = MyData.food!!.mahsulotlar
        binding.txtPreparationOrder.text = MyData.food!!.tartibi

        return binding.root
    }

}