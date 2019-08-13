object QuickSortSimple {

    @JvmStatic
    fun main(args: Array<String>) {

        val arrayToSort = arrayListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
        val sortedArray = quickSort(arrayToSort)
        printArray(sortedArray)
    }

    private fun quickSort(array: List<Int>): List<Int> {
        return if (array.size < 2) {
            array
        } else {
            val pivot = array[0]
            val lower = quickSort(findElements(array) { item -> item <= pivot })
            val higher = quickSort(findElements(array) { item -> item > pivot })
            val resultArray = arrayListOf<Int>().apply {
                addAll(lower)
                add(pivot)
                addAll(higher)
            }
            (resultArray)

        }

    }

    private fun findElements(array: List<Int>, checkIfShouldAdd: (Int) -> Boolean): List<Int> {
        return arrayListOf<Int>().apply {
            for (index in 1 until array.size) {
                if (checkIfShouldAdd(array[index])) {
                    this.add(array[index])
                }
            }
        }
    }

    private fun printArray(array: List<Int>) {
        println("Start printArray:")
        array.forEach { item ->
            print("$item,")
        }
        print("\nEnd printing array")
    }
}