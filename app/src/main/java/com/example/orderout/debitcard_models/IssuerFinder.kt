package com.example.orderout.debitcard_models


/**
 * identify the issuer of credit card using the following table
 * https://en.wikipedia.org/wiki/Payment_card_number#Issuer_identification_number_(IIN)
 */
class IssuerFinder {

    companion object {
        fun detect(number: String): CardIssuer = when {
            isVisa(number) -> CardIssuer.VISA
            isMastercard(number) -> CardIssuer.MASTERCARD
            else -> CardIssuer.OTHER
        }

        private fun isVisa(number: String) = number.isNotEmpty() && number.first() == '4'

        /**
         * from 51 to 55, until excludes 56
         * */
        private fun isMastercard(number: String) = number.length >= 2 && number.substring(0, 2).toIntOrNull() in 51 until 56

        }

}