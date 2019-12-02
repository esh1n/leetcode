object RecursiveSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val items = arrayOf(1, 2, 3, 4, 5)
        println("Sum ${recursiveSum(items)}")
    }

    private fun recursiveSum(digits: Array<Int>): Int {
        return when {
            digits.isEmpty() -> 0
            digits.size == 1 -> digits[0]
            else -> digits[0] + recursiveSum(digits.sliceArray(1 until digits.size))
        }
    }
}
