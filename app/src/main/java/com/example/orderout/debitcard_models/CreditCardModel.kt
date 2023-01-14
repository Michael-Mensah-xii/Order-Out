package com.example.orderout.debitcard_models

import com.example.orderout.R

data class CreditCardModel(
    var number: String = "",
    var expiration: String = "0000", // First two digits = month, last two digits = year
    var holderName: String = "",
    var cvc: String = "000",
    var cardEntity: String = "VISA"
) {
    val logoCardIssuer = when(IssuerFinder.detect(number)) {
        CardIssuer.VISA -> {
            R.drawable.logo_visa
        }
        CardIssuer.MASTERCARD -> {
            R.drawable.logo_mastercard
        }
        CardIssuer.OTHER -> {
            null
        }
    }

    /**
     * put a slash in the middle of the string following the format mm/yy
     */
    val formattedExpiration = when {
        expiration.length == 2 -> "$expiration/"
        expiration.length > 2 -> expiration.substring(0, 2) + "/" + expiration.substring(2, expiration.length)
        else -> expiration
    }
}