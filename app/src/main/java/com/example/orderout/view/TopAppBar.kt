package com.example.orderout.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.ui.theme.Green


@Composable
fun TopBar(
           navController: NavController,

           ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Green),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }

        IconButton(onClick = { navController.navigate("cart"){
            popUpTo("cart") { inclusive = true }
        } }) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "cart",
                tint = Color.White
            )
        }

    }

}


@Preview
@Composable
fun SimplePreview() {
    val navController = rememberNavController()
    TopBar(navController)
}
@Preview
@Composable
fun SimplePreview2() {
    //ScaffoldWithTopBar()
}