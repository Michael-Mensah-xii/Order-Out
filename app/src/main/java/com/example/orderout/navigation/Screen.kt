package com.example.orderout.navigation

sealed class Screen(val route: String ){
     object OnBoardingPage: Screen( "onBoarding")
     object HomeScreen: Screen( "home")
     object AddToCartScreen: Screen( "details/{item}")
     object CartScreen: Screen( "cart")
     object PaymentList: Screen( "pay_select")
     object VisaPaymentScreen: Screen( "visa_select")

     fun createRouteWithItem(item : Int):String {
          return "details/$item"
     }
}
