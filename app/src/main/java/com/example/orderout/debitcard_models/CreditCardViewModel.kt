package com.example.orderout.debitcard_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CreditCardViewModel : ViewModel() {
    var name by mutableStateOf("")
    var number by mutableStateOf("")
    var expiration by mutableStateOf("") // mm/yy format
    var cvc by mutableStateOf("")
    var flipped by mutableStateOf(false)
}