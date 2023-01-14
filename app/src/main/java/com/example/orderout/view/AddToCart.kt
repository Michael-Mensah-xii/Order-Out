package com.example.orderout.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.R
import com.example.orderout.model.FoodViewModel
import com.example.orderout.ui.theme.Green
import com.example.orderout.ui.theme.GreenMINT
import com.example.orderout.ui.theme.paleGreen

//create box that displays food item image with details
@Composable
fun FoodItemCheck(
    foodViewModel: FoodViewModel,
    navController: NavController,
) {

    Box(modifier = Modifier
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .heightIn(43.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(paleGreen)
                        .padding(4.dp)
                        .clickable {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.backpressed),
                        contentDescription = null,
                        tint = Green
                    )
                }

                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(paleGreen)
                        .padding(4.dp)
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.favourite),
                        contentDescription = null,
                        tint = Green
                    )
                }

            }
            Image(
                painter = painterResource(id = foodViewModel.image),
                contentDescription = stringResource(id = foodViewModel.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            //Dual Button
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .height(43.dp)
                        .widthIn(121.dp)
                        .background(GreenMINT)
                        .alpha(4f)
                        .padding(8.dp),
                ) {

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(GreenMINT)
                                .padding(4.dp)
                                .clickable {
                                    foodViewModel.decrementQuantity()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier =
                                Modifier
                                    .size(20.dp, 20.dp),
                                painter = painterResource(id = R.drawable.minimize),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "${foodViewModel.cartItemQuantity.value}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                        )


                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(GreenMINT)
                                .padding(4.dp)
                                .clickable {
                                 foodViewModel.incrementQuantity()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp, 20.dp),
                                imageVector = Icons.Default.Add,
                                contentDescription = stringResource(R.string.text_add_icon),
                                tint = Color.White
                            )
                        }
                    }
                }
            }


            //  Spacer(modifier = Modifier.height(8.dp))

            //price and name
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ) {

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = foodViewModel.name),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )

                    Text(
                        text = String.format("GHS %.2f", foodViewModel.quantity.value),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                }
            }

            //Ingredients
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .heightIn(398.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(paleGreen)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(180.dp)
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.Ingredients),
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier
                            .padding(top = 16.dp)

                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = stringResource(id = foodViewModel.description),
                        modifier = Modifier,
                        style = TextStyle(fontSize = 18.sp),
                        overflow = TextOverflow.Clip
                    )

                    Spacer(modifier = Modifier.heightIn(48.dp))
                }


                Column(modifier = Modifier
                    .padding(top = 285.dp)
                    .padding(horizontal = 16.dp)
                ) {
                    Button(
                        modifier = Modifier
                            .heightIn(58.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp),
                        colors = (ButtonDefaults.buttonColors(Green)),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(
                            stringResource(R.string.add_to_cart),
                            color = Color.White,
                            fontSize = 14.sp,

                            )
                    }

                }

                Spacer(modifier = Modifier.heightIn(32.dp))
            }


        }
    }

}

@Composable
fun FoodItemCheckPreview() {
    val navController = rememberNavController()
    val foodViewModel = FoodViewModel("0")
    FoodItemCheck(foodViewModel, navController,)
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodItemCheck() {
    FoodItemCheckPreview()
}

