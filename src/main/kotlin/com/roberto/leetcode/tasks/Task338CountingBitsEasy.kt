package com.roberto.leetcode.tasks

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= n <= 105
 *
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
class Task338CountingBitsEasy {

    fun run() {
        val int = 4

        val result = com.roberto.leetcode.tasks.Task338CountingBitsEasy.Solution().countBits(int)
        println(result)
    }


    /**
     * in:     out:
     * 0 0     0
     * 1 1     01
     * 2 10    011
     * 3 11    0112
     * 4 100   01121
     * 5 101   011212
     * 6 110   0112122
     * 7 111   01121223
     * 8 1000  011212231
     */
    class Solution {
        fun countBits(n: Int): IntArray {
            val dp = IntArray(n + 1)
            if (n == 0) {
                dp[0] = 0
                return dp
            }
            dp[0] = 0
            dp[1] = 1
            for (i in 2..n) {
                if (i % 2 == 0) {
                    dp[i] = dp[i/2]
                } else {
                    dp[i] = dp[i/2] + 1
                }
            }
            return dp
        }
    }

}