package com.roberto.leetcode.tasks

import java.util.HashMap

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

        val result = com.roberto.leetcode.tasks.Task136SingleNumberEasy.Solution().singleNumber(array)
        println(result)
    }

//    most effective solution
//    class Solution {
//        fun singleNumber(nums: IntArray): Int {
//            var result = 0
//            for (num in nums) {
//                result = result xor num
//            }
//            return result
//        }
//    }

    /**
     * iterate nums array
     * store every element to map K:num V:count
     *
     * find element in map that has value 1 and return key
     */
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            val map = HashMap<Int, Int>()
            for (num in nums) {
                var numCnt = map[num] ?: 0
                map[num] = ++numCnt
            }
            return map.entries.find { it.value == 1 }!!.key
        }
    }

}