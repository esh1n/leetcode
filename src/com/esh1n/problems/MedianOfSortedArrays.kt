package com.esh1n.problems

object Solution {
    @JvmStatic
    fun main(str: Array<String>) {
        val num1 = intArrayOf(1, 3)
        val num2 = intArrayOf(2)
        println(findMedianSortedArrays(num1, num2))
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = if (nums1.size > nums2.size) nums2 else nums1
        val b = if (nums1.size > nums2.size) nums1 else nums2
        val m = a.size
        val n = b.size
        var iMin = 0
        var iMax = m
        val halfLen = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = halfLen - i
            if (i < iMax && b[j - 1] > a[i]) {
                iMin = i + 1
            } else if (i > iMin && a[i - 1] > b[j]) {
                iMax = i - 1
            }else{
                val maxLeft = when {
                    i == 0 -> {
                        b[j - 1]
                    }
                    j == 0 -> {
                        a[i - 1]
                    }
                    else -> {
                        a[i - 1].coerceAtLeast(b[j - 1])
                    }
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft.toDouble()
                }
                val minRight: Int = when {
                    i == m -> {
                        b[j]
                    }
                    j == n -> {
                        a[i]
                    }
                    else -> {
                        b[j].coerceAtMost(a[i])
                    }
                }
                return (maxLeft + minRight) / 2.0
            }

        }
        return 0.0
    }
}