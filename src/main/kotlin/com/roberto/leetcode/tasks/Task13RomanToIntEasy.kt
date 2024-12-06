package com.roberto.leetcode.tasks

class Task13RomanToIntEasy {
    fun run() {
        val s = "MCMXCIV"

        val result = com.roberto.leetcode.tasks.Task13RomanToIntEasy.Solution().romanToInt(s)
        println(result)
    }

    class Solution {
        fun romanToInt(s: String): Int {

            val romanToInt = mapOf(
                Pair('I', 1),
                Pair('V', 5),
                Pair('X', 10),
                Pair('L', 50),
                Pair('C', 100),
                Pair('D', 500),
                Pair('M', 1000)
            )

            val substractionRomanToInt = mapOf(
                Pair("IV", 4),
                Pair("IX", 9),
                Pair("XL", 40),
                Pair("XC", 90),
                Pair("CD", 400),
                Pair("CM", 900),
            )

            var result = 0
            var index = 0
            while (index < s.length) {
                if (index + 1 < s.length && substractionRomanToInt.contains(StringBuilder().append(s[index]).append(s[index+1]).toString())) {
                    result += substractionRomanToInt[StringBuilder().append(s[index]).append(s[index+1]).toString()]!!
                    index += 2
                    continue
                }

                result += romanToInt[s[index]]!!
                index++
            }

            return result
        }
    }
}