package com.roberto.leetcode.tasks

class Task62UniquePathsMedium {

    fun run() {
        println(Solution().uniquePaths(3, 7))
    }

    class Solution {
        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m) { Array(n) { -1 } }
            return fillArray(dp, m - 1, n - 1)
        }

        private fun fillArray(dp: Array<Array<Int>>, m: Int, n: Int) : Int {
            if (m == 0 || n == 0) return 1
            if (dp[m][n] != -1) return dp[m][n]

            dp[m][n] = fillArray(dp, m - 1, n) + fillArray(dp, m, n - 1)

            return dp[m][n]
        }
    }
}
