package com.example.orderout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
        horizontalAlignment = Alignment.CenterHorizontally,
     verticalArrangement = Arrangement.SpaceBetween

    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(538.dp)
        )

       /* Text(text = page.description,
            textAlign = TextAlign.Center,fontSize = 14.sp)
        Spacer(modifier = Modifier.height(12.dp))*/
        Row(modifier=Modifier
            .fillMaxWidth()
            .heightIn(min = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = page.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }

}


@Preview
@Composable
fun PageUIPreview() {
    PageUI(page = Page("",R.drawable.are_you_hungry_))
}