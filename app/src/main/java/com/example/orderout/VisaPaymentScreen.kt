package com.example.orderout

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.orderout.ui.theme.Green
import com.example.orderout.ui.theme.GreenMINTalpha
import com.example.orderout.ui.theme.paleGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisaPaymentDetails(navController: NavController) {
    val textState = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .heightIn(119.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    {
        Column() {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .heightIn(43.dp)
                    .fillMaxWidth(),
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
                        navController.navigate("pay_select") {
                            popUpTo("pay_select") { inclusive = true }
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
            Spacer(modifier = Modifier.heightIn(8.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .heightIn(220.dp)

            ) {
                Image(painter = painterResource(id = R.drawable.visa_card_template),
                    contentDescription = "visa card")
            }


        }

        Spacer(modifier = Modifier.heightIn(32.dp))


        Text(
            text = "Cardholder name:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .border(2.dp, color = GreenMINTalpha, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(
                    Color(212, 235, 211, 255)
                ),

            )

        Spacer(modifier = Modifier.heightIn(32.dp))

        Text(
            text = "Card number:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = GreenMINTalpha, shape = RoundedCornerShape(8.dp))
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(
                    Color(212, 235, 211, 255)
                ),
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.visa_vector), "", tint = Color.Blue)
            }

        )

        Spacer(modifier = Modifier.heightIn(32.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = textState.value,
                placeholder = {
                    Text("Expiry date:  MM/YY")
                },
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .border(2.dp, color = GreenMINTalpha, shape = RoundedCornerShape(8.dp))
                    .widthIn(min = 192.dp)
                    .heightIn(min = 60.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(
                        Color(212, 235, 211, 255)
                    ),
            )


            OutlinedTextField(
                value = textState.value,
                placeholder = {
                    Text("CVV:")
                },
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .border(2.dp, color = GreenMINTalpha, shape = RoundedCornerShape(8.dp))
                    .widthIn(min = 137.dp)
                    .heightIn(min = 60.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(
                        Color(212, 235, 211, 255)
                    ),
            )

        }

        Spacer(modifier = Modifier.heightIn(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
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

        Spacer(modifier = Modifier.heightIn(58.dp))

        Column()
        {
            Button(
                modifier = Modifier
                    .padding(bottom = 60.dp)
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = (ButtonDefaults.buttonColors(Green)),
                onClick = { /*TODO*/ })
            {
                Text(
                    text = "Pay now",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }


    }
}


@Composable
fun VisaPaymentScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        VisaPaymentDetails(navController)
    }

}


@Preview(showBackground = true)
@Composable
fun VisaPaymentPreview() {
    val navController = rememberNavController()
    VisaPaymentDetails(navController)

}


@Preview(showBackground = true)
@Composable
fun VisaPaymentScreenPreview() {
    val navController = rememberNavController()
    VisaPaymentScreen(navController)
}

