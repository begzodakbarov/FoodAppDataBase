package com.example.foodappdatabase1.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodappdatabase1.R
import com.example.foodappdatabase1.databinding.FragmentAddFoodBinding
import com.example.foodappdatabase1.databinding.FragmentHomeBinding
import com.example.foodappdatabase1.db.MyDbHelper
import com.example.foodappdatabase1.models.Food


class AddFoodFragment : Fragment() {
    private val binding by lazy { FragmentAddFoodBinding.inflate(layoutInflater) }
    private lateinit var mydbhelper:MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mydbhelper = MyDbHelper(binding.root.context)
        binding.btnSave.setOnClickListener {
            val food = Food(nomi = binding.edtFoodName.text.toString(), mahsulotlar = binding.edtFoodProducts.text.toString(), tartibi = binding.edtPreparationOrder.text.toString())
            mydbhelper.addFood(food)
            findNavController().popBackStack()
        }

        return binding.root
    }

}