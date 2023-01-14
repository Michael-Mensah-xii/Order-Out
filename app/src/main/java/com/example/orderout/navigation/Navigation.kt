package com.example.orderout.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.orderout.model.FoodViewModel
import com.example.orderout.view.*
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun OrderOutApp() {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    // State of topBar & bottomBar, set state to false, if current page route is "onBoarding"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    BottomBarAnimation(navController, bottomBarState, topBarState)


    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    Scaffold(

        topBar = {
            if (topBarState.value) {
                TopBar(navController)
            }
        },
        bottomBar = {
            if (bottomBarState.value) {
                BottomNavigationBar(navController)
            }
        }

    ) {
        NavHost(navController = navController, startDestination = Screen.onBoardingPage.route) {

            //OnBoarding Screen
            composable(route = Screen.onBoardingPage.route) { OnboardingUI(navController) }


            //HomeScreen
            composable(route = Screen.HomeScreen.route) { HomeScreen(navController) }

            //AddToCart Screen
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")
                    ?.let { FoodItemCheck(FoodViewModel(it), navController) }
            }

            //Cart Screen
            composable(route = Screen.CartScreen.route) { CartScreen(navController) }

            //PaymentList Screen
            composable(route = Screen.PaymentList.route) { PaymentList(navController) }

            //VisaPaymentScreen
            composable(route = Screen.VisaPaymentScreen.route) { VisaPaymentScreen(navController) }
        }
    }
}


@Composable
fun BottomBarAnimation(
    navController: NavController,
    bottomBarState: MutableState<Boolean>,
    topBarState: MutableState<Boolean>,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Control BottomBar
    when (navBackStackEntry?.destination?.route) {
        "onBoarding", "pay_select", "cart", "visa_select", "details/{listId}" -> {
            // Hide BottomBar
            bottomBarState.value = false
            // Hide TopBar
            topBarState.value = false
        }
        else -> {
            // Show BottomBar
            bottomBarState.value = true
            // Show TopBar
            topBarState.value = true
        }
    }
}





