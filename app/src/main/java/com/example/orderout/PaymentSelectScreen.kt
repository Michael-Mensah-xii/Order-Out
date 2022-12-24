package com.example.orderout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderout.ui.theme.Green
import com.example.orderout.ui.theme.GreenMINTalpha
import com.example.orderout.ui.theme.paleGreen

//create a composable that displays payment options make it clickable possibly a using a list
@Composable
fun PaymentSelect(
    @DrawableRes drawable: Int,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(101.dp)
        .padding(horizontal = 16.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(paleGreen)
        .clickable { }
    ) {
        Row(
            modifier = Modifier
                .heightIn(69.dp)
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 100.dp, width = 300.dp),
                painter = painterResource(id = drawable),
                contentDescription = "temp",
            )

        }

    }
}

@Composable
fun PaymentList(
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChoosePayment()
        Text(
            text = "Choose your payment method",
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontSize = 16.sp,

            )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .weight(50f)
                .heightIn(303.dp)
                .padding(vertical = 16.dp),
            content = {
                items(paymentdata) { item ->
                    PaymentSelect(
                        drawable = item.drawable,
                    )
                }

            }
        )
    }

}

data class PaymentElementData(
    val drawable: Int,
)

val paymentdata = listOf(
    PaymentElementData(R.drawable.visa2),
    PaymentElementData(R.drawable.mastercard),
    PaymentElementData(R.drawable.paypal),
)


@Composable
fun ChoosePayment() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(188.dp)
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
                    .clickable {  },
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
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Choose Payment",
                style = TextStyle(fontSize = 24.sp, lineHeight = 14.sp),
                modifier = Modifier.padding(vertical = 56.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 114.dp)
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


@Preview(showBackground = true)
@Composable
fun ChoosePaymentPreview() {
    ChoosePayment()
}

@Preview(showBackground = true)
@Composable
fun PaymentListPreview() {
    PaymentList()
}


@Preview(showBackground = true)
@Composable
fun PaymentSelectPreview() {
    PaymentSelect(drawable = R.drawable.visa2)
}