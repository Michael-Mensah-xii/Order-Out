package com.example.orderout

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.orderout.model.DestinationViewModel
import com.example.orderout.ui.theme.OrderOutTheme
import com.example.orderout.view.*
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridActivityScreen()

        }
    }
}


@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridActivityScreen(destinationViewModel: DestinationViewModel = viewModel()) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    // State of topBar & bottomBar, set state to false, if current page route is "onBoarding"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    BottomBarAnimation(navController, bottomBarState, topBarState)


    Log.d("ActivityScreen_title", destinationViewModel.title.value)

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null

    }

    /*val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            null
        }*/




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
        NavHost(navController = navController, startDestination = "onBoarding") {
            composable("onBoarding") { OnboardingUI(navController) }
            composable("home") { HomeScreen(navController, destinationViewModel) }
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")
                    ?.let { FoodItemCheck(it, navController, destinationViewModel) }
            }
            composable("cart") { CartScreen(navController) }
            composable("pay_select") { PaymentList(navController) }
            composable("visa_select") { VisaPaymentScreen(navController) }
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
        "onBoarding" -> {
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

/*
@ExperimentalFoundationApi
@Composable
fun NavigatePage(){
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController ,
        startDestination = "food_data" ,
    ) {
        composable("food_data") {
            Screen.FoodGrid(navController = navHostController)
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ) {
            it.arguments?.getString("item ")?.let { json ->
                val item =  Gson( ).fromJson(json , FoodData::class.java)
                FoodItemCheck("0", navHostController)
            }
        }
    }

}

*/

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OrderOutTheme {
        Greeting("Android")
    }
}