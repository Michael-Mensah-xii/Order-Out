package com.example.orderout.model

import com.example.orderout.R

class FoodDataSource {
    fun loadData(): List<FoodData> {
        return listOf(
            // Rice Pudding
            FoodData(R.drawable.image1,
                R.string.name1,
                3,
                R.string.price_rice_pudding,
                R.string.description1),

            // Sausage Pizza
            FoodData(R.drawable.image2,
                R.string.name2,
                5,
                R.string.price_sausage_pizza,
                R.string.description2),

            //  Burger and Chips
            FoodData(R.drawable.image3,
                R.string.name3,
                4,
                R.string.price_burgers_chips,
                R.string.description3),

            // Rice and Chicken
            FoodData(R.drawable.image4,
                R.string.name4,
                2,
                R.string.price_rice_chicken,
                R.string.description4),

            // Sandwich and Fries
            FoodData(R.drawable.image5,
                R.string.name5,
                4,
                R.string.price_sandwich_fries,
                R.string.description5),

            // Curry Rice
            FoodData(R.drawable.image6,
                R.string.name6,
                3,
                R.string.price_curry_rice,
                R.string.description6)
        )
    }
}


/*
 */