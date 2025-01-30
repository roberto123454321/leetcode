package com.roberto.leetcode.tasks

class Task435NonOverlappingIntervalsMedium {

    fun run() {
        val array = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3)
        )
        println(Solution().eraseOverlapIntervals(array))
    }

    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            intervals.sortWith { interval1, interval2 -> interval1[1] - interval2[1] }

            var prevIntervalEnd = intervals[0][1]
            var cnt = 1

            for (i in 1 until intervals.size) {
                if (prevIntervalEnd <= intervals[i][0]) {
                    cnt++
                    prevIntervalEnd = intervals[i][1]
                }
            }

            return intervals.size - cnt
        }
    }
}

/**
 *
 * prev = 1,2
 * i = 2,3
 *
 * 2 >= 2
 *
 * prev = 1,3
 * i = 2,3
 * 2 >= 3
 *
 */