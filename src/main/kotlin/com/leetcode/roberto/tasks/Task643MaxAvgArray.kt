package com.leetcode.roberto.tasks

import kotlin.math.max

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
class Task643MaxAvgArray {

    fun run() {

//        val array = intArrayOf(8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891)

//        val array = intArrayOf(1,12,-5,-6,50,3)
//        val result = Solution().findMaxAverage(array, 4)

        val array = intArrayOf(-1)
        val result = Solution().findMaxAverage(array, 1)
        println(result)
    }

    class Solution {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var max = Int.MIN_VALUE.toDouble()
            var start = 0
            var end = 0
            var sum = 0

            while (end < nums.size) {
                sum = sum + nums[end]
                if (end - start + 1 == k) {
                    max = max(max, sum.toDouble()/k)
                    sum = sum - nums[start]
                    start++
                }
                end++
            }

            return max
        }
    }


    //MY solution -> too slow
    /**
     * array 1,12,-5,-6,50,3
     * k 4
     *
     * in: array of numbers
     * out: int = greates avg of K numbers from whole array
     *
     * note:
     * avg to 10^5
     *
     * edge:
     * empty array=0
     * null array=0
     *
     * what if less number in array than K? = 0?
     *
     * ex:
     * 1,12,-5,-6=2/4
     * 12,-5,-6-50=51/4
     * -5,-6,50,3=42/4
     *
     * array 1,12,-5,-6,50,3
     * k 4
     * arraysize 6
     *
     * max 0 2/4 51/4
     * l 0 1 2 3
     * r 3 4 5 6
     * curr 0 1+12-5-6=2/4 12,-5,-6-50=51/4 -5,-6,50,3=42/4
     */
//    class Solution {
//        fun findMaxAverage(nums: IntArray, k: Int): Double {
//            if (nums.isEmpty()) {
//                return 0.0
//            }
//
//            if (nums.size == 1) {
//                return nums[0].toDouble()
//            }
//
//            var maxAvg : Double? = null
//            var left = 0
//            var right = k - 1
//
//            while (right < nums.size) {
//                var currentAvg = 0.0
//                for (i in left..right) {
//                    currentAvg += nums[i]
//                }
//                currentAvg /= k
//
//                if (maxAvg == null || currentAvg > maxAvg!!) {
//                    maxAvg = currentAvg
//                }
//
//                left++
//                right++
//            }
//            return maxAvg ?: 0.0
//        }
//    }

}