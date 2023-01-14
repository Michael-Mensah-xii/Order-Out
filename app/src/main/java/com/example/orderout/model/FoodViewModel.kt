package com.example.orderout.model

import androidx.compose.runtime.mutableStateOf


class FoodViewModel(private val index: String) {
    private val dataSource = FoodDataSource().loadData()
    private val destination = dataSource[index.toInt()]
    val name: Int = destination.name
    val rating: Int = destination.rating
    val description: Int = destination.description
    val image: Int = destination.id
    var price: Double = destination.price
    val quantity = mutableStateOf(price)
    val cartItemQuantity = mutableStateOf(1)

    fun incrementQuantity() {
        quantity.value += price
        cartItemQuantity.value += 1
    }


    fun decrementQuantity() {
        quantity.value -= price
        cartItemQuantity.value -= 1
    }



    // other logic


}


