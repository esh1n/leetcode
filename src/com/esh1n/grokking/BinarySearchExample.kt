object BinarySearchExample {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = arrayOf(1, 3, 5, 7, 9)
        println("search of 3 ${binarySearch(list, 3)}")
        println("search of -2 ${binarySearch(list, -2)}")
    }

    fun binarySearch(list: Array<Int>, item: Int, fallback: Int = -1): Int {
        var low = 0
        var high = list.size - 1


        while (low <= high) {
            var mid = (low + high) / 2
            var guess = list[mid]
            when {
                guess == item -> return mid
                guess > item -> high = mid - 1
                else -> low = mid + 1
            }
        }
        return fallback
    }
}


