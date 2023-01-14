package com.example.orderout.debitcard_models

class InputValidator {

    companion object {
        fun parseNumber(number: String): String? = when {
            checkNumber(number) -> number
            number.isEmpty() -> ""
            else -> null
        }

        fun parseHolderName(name: String): String? = when {
            checkHolderName(name) -> name
            name.isEmpty() -> ""
            else -> null
        }

        fun parseCVC(cvc: String): String? = when {
            checkCVC(cvc) -> cvc
            cvc.isEmpty() -> ""
            else -> null
        }

        private fun checkNumber(number: String): Boolean =
            number.isNotEmpty() && number.length <= 16 && number.last().isDigit()

        private fun checkHolderName(name: String): Boolean =
            name.isNotEmpty() && (name.last().isLetter() || name.last() == ' ')

        private fun checkCVC(cvc: String): Boolean =
            cvc.isNotEmpty() && cvc.last().isDigit() && cvc.length <= 3
    }
}

/**
This is a class called "InputValidator" that provides methods for validating different types of input for a credit card.
The class includes three methods: parseNumber, parseHolderName, and parseCVC, which are used to validate credit card number,
holder's name, and CVC code respectively. All of them take a string as input and return a string if the input is valid,
empty string if input is empty, otherwise it return null.
The parseNumber method checks if the input is not empty and if it's length is not greater than 16,
it also checks if the last character is digit.
The parseHolderName method checks if the input is not empty and the last character is a letter or a space.
The parseCVC method checks if the input is not empty and if the last character is a digit and the length of the input is less or equals than 3.
 **/