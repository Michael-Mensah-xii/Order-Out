package com.example.orderout.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
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
import com.example.orderout.R
import com.example.orderout.debitcard_models.*
import com.example.orderout.debitcard_views.CreditCard
import com.example.orderout.debitcard_views.CustomTextField
import com.example.orderout.ui.theme.Green
import com.example.orderout.ui.theme.GreenMINTalpha
import com.example.orderout.ui.theme.paleGreen

@Composable
fun VisaPaymentDetails(navController: NavController, viewModel: CreditCardViewModel) {

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
                        navController.navigateUp()

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

            CreditCardModel()

            CreditCard(
                number = viewModel.number,
                expiration = viewModel.expiration,
                holderName = viewModel.name,
                cvc = viewModel.cvc,
                flipped = viewModel.flipped,
                emptyChar = 'X',
                showSecurityCode = false
            )

        }

        Spacer(modifier = Modifier.heightIn(16.dp))


        Text(
            text = "Cardholder name:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        CustomTextField(
            value = viewModel.name,
            onValueChange = {
                InputValidator.parseHolderName(it)?.let { name ->
                    viewModel.name = name
                }
            },
            modifier = Modifier
                .onFocusChanged { state ->
                    if (state.isFocused) viewModel.flipped = false
                }
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

        Spacer(modifier = Modifier.heightIn(16.dp))

        Text(
            text = "Card number:",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        CustomTextField(
            value = viewModel.number,
            onValueChange = {
                viewModel.number =
                    if (viewModel.number.length >= 16) viewModel.number.substring(0..15) else it


            },
            modifier = Modifier
                .onFocusChanged { state ->
                    if (state.isFocused) viewModel.flipped = false
                }
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

        Spacer(modifier = Modifier.heightIn(24.dp))


        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(
                value = viewModel.expiration,
                visualTransformation = InputTransformation(FieldType.EXPIRATION),
                placeholder = "Expiry date:  MM/YY",
                onValueChange = {
                    viewModel.expiration = if (it.length >= 4) it.substring(0..3) else it

                    // When value is completed, request focus of next field
                    // if (viewModel.expiration.length >= 4) focusCVC.requestFocus()
                },

                modifier = Modifier
                    .onFocusChanged { state ->
                        if (state.isFocused) viewModel.flipped = false
                    }
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

            CustomTextField(
                value = viewModel.cvc,
                placeholder = "CVV",
                onValueChange = {
                    InputValidator.parseCVC(it)?.let { cvc ->
                        viewModel.cvc = cvc
                    }
                },
                modifier = Modifier
                    .onFocusEvent { state ->
                        if (state.isFocused) viewModel.flipped = true
                    }
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
                    .padding(bottom = 24.dp)
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
        VisaPaymentDetails(navController, viewModel = CreditCardViewModel())
    }

}


@Preview(showBackground = true)
@Composable
fun VisaPaymentScreenPreview() {
    val navController = rememberNavController()
    VisaPaymentScreen(navController)
}

