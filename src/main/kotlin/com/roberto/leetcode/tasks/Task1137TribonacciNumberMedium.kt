package com.roberto.leetcode.tasks

class Task1137TribonacciNumberMedium {

    fun run() {
        println(Solution().tribonacci(25))
    }

    /**
     * intuition: use 1d dynamic programming. array which stores previous results to calculate next result.
     *
     * pseudocode:
     * init int array of size n+1
     * array will contain first 3 numbers, which are hardcoded constants
     * if n < 3 return n element from array
     * create for loop from 3 to n, that check elements in array at position n-1 n-2 n-3 and will return n element from array
     *
     *
     * t0 t1 t2 t3                t4       t5
     * 0, 1, 1  t0+t1+t2=0+1+1=2  1+1+2=4  1+2+4=7
     *
     */
    class Solution {
        fun tribonacci(n: Int): Int {
            val arraySize = if (n < 2) 3 else n + 1
            val dp = IntArray(arraySize)
            dp[0] = 0
            dp[1] = 1
            dp[2] = 1

            if (n < 3) {
                return dp[n]
            }

            for (i in 3..n) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
            }

            return dp[n]
        }
    }
}
