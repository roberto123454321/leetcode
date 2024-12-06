package com.roberto.leetcode.tasks

import kotlin.math.min


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 *
 */
class Task14LongestCommonPrefixEasy {

    fun run() {
        val s = arrayOf("abflow","flow","flowly")

        val result = com.roberto.leetcode.tasks.Task14LongestCommonPrefixEasy.Solution().longestCommonPrefix(s)
        println(result)
    }

    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            //sort so we have alphabetically sorted words
            strs.sort()

            val first = strs[0]
            val last = strs[strs.size -1]

            val res = StringBuilder()

            //it is prefix string,
            //so if the strings have the same sequence in the middle of the word,
            //the condition will not pass
            for (i in 0 until min(first.length, last.length)) {
                if (first[i] != last[i]) {
                    return res.toString()
                }
                res.append(first[i])
            }
            return res.toString()
        }
    }

}