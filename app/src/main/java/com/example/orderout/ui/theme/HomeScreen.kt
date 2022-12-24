package com.example.orderout.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


//create atopbar with burger menu icon and a cart icon that opens up to cart


// create a homescreen where all items will be
@Composable
fun HomeScreen(modifier: Modifier){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column( ) {

        }


    }
}






//create an image view or card view list that displays food
//also possibly fetch food info from a local database




@Composable
fun AppBar() {
    
}

/*@Preview
@Composable
fun RatingPreview() {
    RatingBar(rating = 2.5)
}*/


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

}





/*// This function defines a RatingBar composable for displaying a rating as a number of filled and unfilled stars.
@Composable
fun RatingBar(
    // The Modifier parameter is used to specify modifications to the composable's layout, appearance, or behavior.
    modifier: Modifier = Modifier,
    // The rating parameter specifies the rating to display. It has a default value of 0.0.
    rating: Double = 0.0,
    // The stars parameter specifies the total number of stars to display. It has a default value of 5.
    stars: Int = 5,
    // The starsColor parameter specifies the color to use for the filled stars. It has a default value of Color.Yellow.
    starsColor: Color = Color.Yellow,
) {
    // We round down the rating to the nearest integer to determine how many stars to fill.
    val filledStars = floor(rating).toInt()
    // We subtract the number of filled stars from the total number of stars to determine how many unfilled stars to display.
    val unfilledStars = (stars - kotlin.math.ceil(rating)).toInt()
    // We use the remainder operator to check if the decimal part of the rating is not equal to 0.0, in which case we will display a half-filled star.
    val halfStar = !(rating.rem(1).equals(0.0))

    // We use a Row composable to arrange the stars in a horizontal row.
    Row(modifier = modifier) {
        // We use the repeat() function to display the specified number of filled stars.
        repeat(filledStars) {
            // We use the Icon composable to display a filled star.
            Icon(
                // We specify the image vector for the filled star.
                imageVector = Icons.Outlined.Star,
                // We do not provide a content description for the icon because it is self-explanatory.
                contentDescription = null,
                // We specify the color to use for the filled stars.
                tint = starsColor
            )
        }

        // If the rating has a decimal part that is not equal to 0.0, we display a half-filled star.
        if (halfStar) {
            // We use the Icon composable to display a half-filled star.
            Icon(
                // We specify the image vector for the half-filled star.
                imageVector = Icons.Outlined.StarHalf,
                // We do not provide a content description for the icon because it is self-explanatory.
                contentDescription = null,
                // We specify the color to use for the filled stars.
                tint = starsColor
            )
        }

        // We use the repeat() function to display the specified number of unfilled stars.
        repeat(unfilledStars) {
            // We use the Icon composable to display an unfilled star.
            Icon(
                // We specify the image vector for the unfilled star.
                imageVector = Icons.Outlined.StarOutline,
                // We do not provide a content description for the icon because it is self-explanatory.
                contentDescription = null,
                // We specify the color to use for the filled stars.
                tint = starsColor
            )
        }
    }
}
*/
