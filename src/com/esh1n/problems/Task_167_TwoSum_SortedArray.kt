package com.esh1n.problems

object Task_167_TwoSum_SortedArray {
    @JvmStatic
    fun main(args: Array<String>) {

        val map = mapOf(intArrayOf(1, 2, 3, 4, 4, 9, 56, 90) to 8, intArrayOf(2, 3, 4) to 6, intArrayOf(-1, 0) to -1)
        map.forEach { (array, target) ->
            val result = twoSum(array, target)
            println("search of $target ${result.joinToString()}")
        }
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        numbers.forEachIndexed { index, number ->
            val aimIndex = numbers.binarySearch(target - number, index + 1, numbers.size)
            if (aimIndex > 0) {
                return intArrayOf(index + 1, aimIndex + 1)
            }
        }
        return intArrayOf()
    }

    private fun IntArray.biSearch(start: Int, end: Int, search: Int): Int {
        var low = start
        var high = end
        while (low <= high) {
            val pivot = (high + low) / 2
            val med = get(pivot)
            when {
                med == search -> return pivot
                search > med -> low = pivot + 1
                search < med -> high = pivot - 1
            }
        }
        return -1
    }
}