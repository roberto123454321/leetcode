package com.leetcode.roberto.tasks

class Task1 {
    fun run() {
//        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
//        val target = 9
        val nums = intArrayOf(3, 3)
        val target = 6

        val result = Solution().twoSum(nums, target)
        println(result.joinToString(" "))
    }

    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val numPositions = mutableMapOf<Int, Int>()

            nums.forEachIndexed { index, i ->
                if (numPositions.containsKey(target - i)) {
                    return intArrayOf(index, numPositions[target - i]!!)
                } else {
                    numPositions[i] = index
                }
            }
            return intArrayOf()
        }
    }
}