package com.example.orderout.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class FoodData(
    @DrawableRes val id: Int,
    @StringRes val name: Int,
    val rating: Int,
    val price: Double,
    @StringRes val description: Int,
)

