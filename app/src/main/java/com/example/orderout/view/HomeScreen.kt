package com.example.orderout.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.orderout.R
import com.example.orderout.model.FoodData
import com.example.orderout.model.FoodDataSource
import com.example.orderout.ui.theme.RatingYellow

@Composable
fun HomeScreen(onItemClick: (item: Int) -> Unit) {
    val destinations = FoodDataSource().loadData()

    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 40.dp)
    ) {
        itemsIndexed(destinations) { item, destination ->
            ItemLayout(destination, onItemClick = { onItemClick(item) })
        }
    }
}


@Composable
fun ItemLayout(
    destination: FoodData,
    onItemClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        Image(
            painter = painterResource(destination.id),
            contentDescription = stringResource(destination.name),
            modifier = Modifier
                .clickable { onItemClick() }
                .size(height = 170.dp, width = 170.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.heightIn(10.dp))

        Text(
            text = stringResource(destination.name),
            color = Color.Black,
            fontSize = 14.sp,
        )
        Rating(rating = destination.rating)
        Text(
            text = String.format("GHS %.2f", destination.price),
            color = Color.Black,
            fontSize = 10.sp,
        )
    }
}


//create rating system
@Composable
fun Rating(
    rating: Int,
) {
    Row {
        for (i in 1..5) {
            if (i <= rating) {
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
    val destination = FoodData(
        id = R.drawable.image1,
        name = R.string.name1,
        description = R.string.description1,
        rating = 4,
        price = 30.00
    )
    ItemLayout(destination, onItemClick = {})
}


@Preview(showBackground = true)
@Composable
fun RatingPreview() {
    Rating(rating = 1)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onItemClick = {})
}



