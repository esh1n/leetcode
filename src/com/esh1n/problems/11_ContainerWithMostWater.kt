package com.esh1n.problems

object `11_ContainerWithMostWater` {

    @JvmStatic
    fun main(args: Array<String>) {
        println("water of 1 ${maxArea(intArrayOf(1, 1))}")
        println("water of 2 ${maxArea(intArrayOf(1, 2, 1))}")
        println("water of 3 ${maxArea(intArrayOf(4, 3, 2, 1, 4))}")
    }

    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var maxArea = 0
        while (l < r) {
            val left = height[l]
            val right = height[r]
            maxArea = Math.max(maxArea, (r - l) * Math.min(left, right))
            if (left > right) {
                l++
            } else {
                r--
            }
        }
        return maxArea

    }
}