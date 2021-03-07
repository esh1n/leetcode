package com.esh1n.problems

object `15_3Sum` {

    @JvmStatic
    fun main(args: Array<String>) {

        val list = listOf(intArrayOf(0,0,0,0), intArrayOf(), intArrayOf(0))
        list.forEach { array ->
            val result = threeSum(array)
            result.forEach {
                println(it.joinToString())
            }
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        nums.forEachIndexed { index, number ->
            if (index < nums.size - 2) {
                if (index == 0 || (index > 0 && nums[index] != nums[index - 1])) {
                    val innerNums = nums.slice(index + 1 until nums.size)
                    val indexSums = twoSum(innerNums, 0 - nums[index])
                    val filteredValues = indexSums.map {
                        val realIndexes = it.map { i ->
                            val finalIndex = i + index + 1
                            finalIndex
                        }.toMutableList().apply { add(0, index) }
                         realIndexes.map { nums[it] }
                    }.distinct()
                    result.addAll(filteredValues)
                }
            }
        }
        return result
    }

    fun twoSum(numbers: List<Int>, target: Int): List<List<Int>> {
        val twoSumResults = mutableListOf<List<Int>>()
        numbers.forEachIndexed { index, number ->
            val aimIndex = numbers.binarySearch(target - number, index + 1, numbers.size)
            if (aimIndex > 0) {
                twoSumResults.add(listOf(index, aimIndex))
            }
        }
        return twoSumResults.distinct()
    }
}