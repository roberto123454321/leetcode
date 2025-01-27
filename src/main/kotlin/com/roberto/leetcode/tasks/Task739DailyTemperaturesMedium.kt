package com.roberto.leetcode.tasks

import java.util.*

class Task739DailyTemperaturesMedium {
    fun run() {

        val temps = intArrayOf(73,74,75,71,69,72,76,73)
        val result = Solution().dailyTemperatures(temps)
        println(result.joinToString(separator = ", "))
    }

    class Solution {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val result = IntArray(temperatures.size)
            val stack = Stack<Int>()

            for (i in temperatures.indices) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.pop()
                }
                stack.push(i)
            }

            return result
        }
    }
}