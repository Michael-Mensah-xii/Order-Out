package com.example.orderout.debitcard_views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderout.debitcard_models.CreditCardViewModel


class CreditCardActivity : ComponentActivity() {
    private val viewModel by viewModels<CreditCardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutCreditCard(
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun LayoutCreditCard(viewModel: CreditCardViewModel) {
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp
        )
    ) {
        CreditCard(
            number = viewModel.number,
            expiration = viewModel.expiration,
            holderName = viewModel.name,
            cvc = viewModel.cvc,
            flipped = viewModel.flipped,
            emptyChar = 'X',
            showSecurityCode = false
        )

        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun MyCreditCardPreview() {
    val mockViewModel = CreditCardViewModel()
    mockViewModel.name = ""
    mockViewModel.number = ""
    mockViewModel.expiration = "0228"

    Column(
        modifier = Modifier.width(500.dp)
    ) {
        LayoutCreditCard(
            viewModel = mockViewModel
        )
    }
}