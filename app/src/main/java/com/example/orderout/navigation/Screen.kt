package com.example.orderout.navigation

sealed class Screen(val route: String ){
     object onBoardingPage: Screen( "onBoarding")
     object HomeScreen: Screen( "home")
     object AddToCartScreen: Screen( "details/{listId}")
     object CartScreen: Screen( "cart")
     object PaymentList: Screen( "pay_select")
     object VisaPaymentScreen: Screen( "visa_select")
}
