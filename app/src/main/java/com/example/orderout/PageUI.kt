package com.example.orderout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderout.ui.theme.Page

@Composable
fun PageUI(page: Page) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(528.dp),

            )
        /* Spacer(modifier = Modifier.height(12.dp))*/
        Text(
            text = page.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }

}


@Preview(showBackground = true)
@Composable
fun PageUIPreview() {
    PageUI(page = Page("Find some food", R.drawable.find_some_food))
}