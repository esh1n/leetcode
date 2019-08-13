import java.lang.StringBuilder

object YandexCountOfItems {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
        println("Sum ${RLE(input)}")
    }

    private fun RLE(input: String): String {
        val result = StringBuilder("")
        when {
            input.isNullOrBlank() -> return result.toString()
            input.length == 1 -> return input
            else -> {
                var currentChar = input[0]
                var numberOfOccasions = 1
                val subInput = input.substring(1)
                for (i in subInput.indices) {
                    if (subInput[i] == currentChar && i != subInput.length - 1) {
                        numberOfOccasions++
                    } else {
                        when (numberOfOccasions) {
                            1 -> result.append(currentChar)
                            else -> result.append(currentChar).append(numberOfOccasions)
                        }
                        numberOfOccasions = 1
                        currentChar = subInput[i]
                    }
                }
            }
        }

        return result.toString()
    }


}
