package com.example.orderout.debitcard_models

/**
 * Parse credit card number, split it in blocks
 */
class CardNumberParser(
    private val number: String,
    private val emptyChar: Char = DEFAULT_EMPTY_CHAR
) {
    lateinit var first: String
    lateinit var second: String
    lateinit var third: String
    lateinit var fourth: String

    init {
        splitCardNumber()
    }

    /**
     * create a block using xxxx format
     * depending on emptyChar value
     */
    private fun initEmptyBlock() = "".padEnd(BLOCK_SIZE, emptyChar)

    /**
     * split card number in 4 parts, each block of 4 characters
     * if card number has less than 16 char, then the missing string is filled using emptyChar parameter
     * if card number has more than 16 char, then the leftover string is discarded
     */
    private fun splitCardNumber() {
        first = getBlock(blockNumber = FIRST)
        second = getBlock(blockNumber = SECOND)
        third = getBlock(blockNumber = THIRD)
        fourth = getBlock(blockNumber = FOURTH)
    }

    /**
     * get a block of card number
     * [1,2,3,4] represents xxxx-xxxx-xxxx-xxxx
     */
    private fun getBlock(blockNumber: Int): String {
        val length = number.length
        var block = initEmptyBlock()
        val start = (blockNumber - 1) * BLOCK_SIZE
        val end = blockNumber * BLOCK_SIZE

        if (length in start until end) {
            block = number
                .substring(start, length)
                .padEnd(BLOCK_SIZE, emptyChar)
        } else if (number.length >= start) {
            block = number.substring(start, end)
        }

        return block
    }

    companion object {
        private const val DEFAULT_EMPTY_CHAR = 'x'
        private const val BLOCK_SIZE = 4
        private const val FIRST = 1
        private const val SECOND = 2
        private const val THIRD = 3
        private const val FOURTH = 4
    }
}


/**
 * This is a class called "CardNumberParser"
 * that is used to split a credit card number into four separate blocks of four characters each.
 * It takes in a credit card number and an optional character for padding (defaults to 'x').
 * The class splits the number into four separate properties: first,
 * second, third, and fourth. The number is split by calling the private method "splitCardNumber",
 * which calls the private method "getBlock" for each of the four properties and passes in a block number.
 * This method uses the block number to determine the start and end index for the substring,
 * and pads the substring with the emptyChar character if the credit card number is less than 16 characters.
 **/


