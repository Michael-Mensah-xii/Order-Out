package com.example.orderout.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.orderout.R

@Immutable
data class Page(
   // val description: String,
    val title: String,
    @DrawableRes val image:Int
)


class PageRepository {

    fun getOnboardingPages(): List<Page> {
        return onboardPages
    }
}

val repository = PageRepository()
val pages = repository.getOnboardingPages()


val onboardPages = listOf(
    Page(
        //"Easy Momo Transfer",
        "Are you hungry?",
        R.drawable.are_you_hungry_
    ),
    Page(
        //"Easy Select",
        "Looking for something delicious to order?",
        R.drawable.looking_for_something_delicious_to_order_
    ),
    Page(
        //"Secure",
        "Find some food!",
        R.drawable.find_some_food
    )
)


