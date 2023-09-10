package com.example.foodappdatabase1.db

import com.example.foodappdatabase1.models.Food

interface MyDbInterface {

    fun addFood(food: Food)
    fun getAllFood():List<Food>
}