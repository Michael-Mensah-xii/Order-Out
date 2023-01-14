package com.example.orderout.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.R
import com.example.orderout.model.FoodData
import com.example.orderout.model.FoodDataSource
import com.example.orderout.ui.theme.RatingYellow

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val destinations = FoodDataSource().loadData()



    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.padding(bottom = 48.dp)
    ) {
        itemsIndexed(destinations) { index, destination ->
            Row(Modifier.padding(8.dp)) {
                ItemLayout(destination, index, navController)
            }
        }
    }
}


@Composable
fun ItemLayout(
    destination: FoodData,
    index: Int,
    navController: NavHostController,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .widthIn(185.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navController.navigate("details/$index")
            }
    ) {
        Image(
            painter = painterResource(destination.id),
            contentDescription = stringResource(destination.name),
            modifier = Modifier
                .widthIn(185.dp)
                .heightIn(140.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.heightIn(10.dp))

        Text(
            text = stringResource(destination.name),
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Rating(rating = destination.rating)
        Text(
            text = String.format("GHS %.2f", destination.price),
            color = Color.Black,
            fontSize = 10.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}


//create rating system
@Composable
fun Rating(
    rating: Int, modifier: Modifier = Modifier,
) {
    Row(modifier.padding(horizontal = 16.dp)
    ) {
        for (i in 1..5) {
            if (i <= rating) {
                //  Image(painter = painterResource(id = R.drawable.ic_star))
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    tint = RatingYellow,
                    contentDescription = null,
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star_empty),
                    contentDescription = null,
                )
            }
        }
    }
}


@Preview
@Composable
fun ItemLayoutPreview() {
    val navController = rememberNavController()
    val destination = FoodData(
        id = R.drawable.image1,
        name = R.string.name1,
        description = R.string.description1,
        rating = 4,
        price = 30.00
    )
    ItemLayout(destination, 0, navController)
}


@Preview(showBackground = true)
@Composable
fun RatingPreview() {
    Rating(rating = 1)
}





