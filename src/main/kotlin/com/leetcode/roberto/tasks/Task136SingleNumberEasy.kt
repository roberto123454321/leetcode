package com.leetcode.roberto.tasks

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */
class Task136SingleNumberEasy {

    fun run() {
        val array = intArrayOf(2,2,1)

        val result = Solution().singleNumber(array)
        println(result)
    }

    class Solution {
        fun singleNumber(nums: IntArray): Int {
            var result = 0
            for (num in nums) {
                result = result xor num
            }
            return result
        }
    }

}