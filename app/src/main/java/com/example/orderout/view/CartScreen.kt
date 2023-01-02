package com.example.orderout.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.R
import com.example.orderout.ui.theme.Green
import com.example.orderout.ui.theme.GreenArmy
import com.example.orderout.ui.theme.GreenMINTalpha
import com.example.orderout.ui.theme.paleGreen

//Create a view that displays total price in a text view
@Composable
fun TotalPrice(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(32.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .heightIn(43.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(paleGreen)
                    .padding(4.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.backpressed),
                        contentDescription = null,
                        tint = Green
                    )
                }

            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Cart",
                style = TextStyle(fontSize = 24.sp, lineHeight = 14.sp),
                modifier = Modifier.padding(vertical = 48.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 82.dp)
                .padding(horizontal = 16.dp)
                .heightIn(45.dp)
                .background(GreenMINTalpha),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Total price:",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "GHS 1200.00",
                fontSize = 14.sp,
                color = Color.Black,
            )

        }

    }


}

//create a box that displays food item image with an increase decrease icon
@Composable
fun CartElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes price: Int,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(101.dp)
        .padding(horizontal = 16.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(paleGreen)
    ) {
        Row(
            modifier = Modifier
                .heightIn(69.dp)
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(width = 109.dp, height = 69.dp),
                painter = painterResource(id = drawable),
                contentDescription = "temp",
            )
            Column(modifier = Modifier
                .heightIn(69.dp)
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = text),
                    style = TextStyle(fontSize = 15.sp, lineHeight = 14.sp),
                    modifier = Modifier.paddingFromBaseline(
                        top = 12.dp, bottom = 2.dp
                    )
                )

                Text(
                    text = stringResource(id = price),
                    style = TextStyle(fontSize = 12.sp, lineHeight = 14.sp),
                    color = Color.Black,
                    modifier = Modifier.paddingFromBaseline(
                        top = 2.dp, bottom = 12.dp
                    )
                )
            }

            Column(
                modifier = Modifier
                    .heightIn(69.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                CartItemButton()
            }
        }

    }
}


@Composable
fun CartElementColumn(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        TotalPrice(navController)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .weight(50f)
                .heightIn(303.dp)
                .padding(vertical = 16.dp),
            content = {
                items(cartData) { item ->
                    CartElement(
                        drawable = item.drawable,
                        text = item.text,
                        price = item.price

                    )

                }

            }
        )
        ConfirmOrderButton(navController)
    }
}


data class CartElementData(
    val drawable: Int,
    val text: Int,
    val price: Int,
)

val cartData = listOf(
    CartElementData(R.drawable.add_to_cart_1, R.string.temp_item_string, R.string.temp_price),
    CartElementData(R.drawable.add_to_cart_2, R.string.temp_item_string, R.string.temp_price),
    CartElementData(R.drawable.add_to_cart_3, R.string.temp_item_string, R.string.temp_price),
)


// plus & minus button
@Composable
fun CartItemButton() {
    Box(
        modifier = Modifier
            .height(43.dp)
            .padding(8.dp)
            .widthIn(20.dp)
            .background(paleGreen),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(GreenArmy)
                    .padding(4.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier =
                    Modifier
                        .size(10.dp),
                    painter = painterResource(id = R.drawable.minimize),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Text(
                text = "2",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(GreenArmy)
                    .padding(4.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.text_add_icon),
                    tint = Color.White
                )
            }
        }
    }

}

//create a button that says confirm order
@Composable
fun ConfirmOrderButton(navController: NavController) {
    Column(modifier = Modifier
        .padding(bottom = 32.dp)
        .padding(horizontal = 16.dp)
    ) {
        Button(
            modifier = Modifier
                .heightIn(58.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            colors = (ButtonDefaults.buttonColors(Green)),
            onClick = {
                navController.navigate("pay_select") {
                    popUpTo("pay_select") { inclusive = true }
                }
            }
        ) {
            Text(
                stringResource(R.string.confirm_button),
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }

}


//Screen
@Composable
fun CartScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        CartElementColumn(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun TotalPricePreview() {
    val navController = rememberNavController()

    TotalPrice(navController)
}

@Preview(showBackground = true)
@Composable
fun CartElementPreview() {
    CartElement(drawable = R.drawable.add_to_cart_1,
        text = R.string.temp_item_string,
        price = R.string.temp_price)
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    val navController = rememberNavController()
    CartScreen(navController)
}