package com.example.orderout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUI(navController: NavController) {
    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage
    val currentImage = onboardPages[currentPage].image

    Column(Modifier
        .fillMaxWidth()
        .background(color = when (currentImage) {
            0 -> Page1
            1 -> Page2
            2 -> Page3
            else -> Page1
        })
    ) {
        HorizontalPager(
            state = pagerState,
            count = onboardPages.size,
            contentPadding = PaddingValues(horizontal = 0.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)) { page ->
            PageUI(page = onboardPages[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .weight(1f),
            activeColor = Green,
            indicatorWidth = 10.dp,
            indicatorHeight = 10.dp
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            Button(shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    Green,
                    contentColor = Color.White)) {
                Text(text = stringResource(R.string.get_started))
            }
        }

    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun Ncncncn() {
    val navController = rememberNavController()
    OnboardingUI(navController)

}