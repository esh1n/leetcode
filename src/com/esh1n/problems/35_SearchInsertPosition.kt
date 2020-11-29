package com.esh1n.problems

object `35_SearchInsertPosition` {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = intArrayOf(1, 3, 5, 6)
        val list1 = intArrayOf(1, 3)
        //println("search of 5 ${searchInsert(list, 5)}")
        println("search of 2 ${searchInsert(list, 2)}")
        println("search of 2 ${searchInsert(list1, 2)}")
        println("search of 7 ${searchInsert(list, 7)}")
        println("search of 0 ${searchInsert(list, 0)}")
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        var mid = 0
        while (low <= high) {
            mid = (low + high) / 2
            val current = nums[mid]
            when {
                current == target -> {
                    return mid
                }
                current < target -> {
                    low = mid + 1
                }
                else -> {
                    high = mid - 1
                }
            }
        }
        return if (high < 0) {
            low
        } else {
            mid + 1
        }
    }
}