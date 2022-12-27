package com.example.orderout

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orderout.ui.theme.CartScreen
import com.example.orderout.ui.theme.DestinationViewModel
import com.example.orderout.ui.theme.OrderOutTheme
import com.example.orderout.view.BottomNavigationBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridActivityScreen()

        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridActivityScreen(destinationViewModel: DestinationViewModel = viewModel()) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    Log.d("ActivityScreen_title", destinationViewModel.title.value)

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            null
        }

    Scaffold(

        topBar = {
            TopBar(navController)
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }

    ) {
        NavHost(navController = navController, startDestination = "home") {
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