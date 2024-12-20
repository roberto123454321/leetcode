package com.roberto.leetcode.tasks

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
class Task1768MergeStringsAlternatelyEasy {

    fun run() {
        val s1 = "abcdef"
        val s2 = "pqrstuvwxyz"

        val result = com.roberto.leetcode.tasks.Task1768MergeStringsAlternatelyEasy.Solution().mergeAlternately(s1, s2)
        println(result)
    }

    class Solution {
        fun mergeAlternately(word1: String, word2: String): String {
            val result = StringBuilder()

            var index = 0

            while (index < word1.length && index < word2.length) {
                result.append(word1[index])
                result.append(word2[index])
                index++
            }

            if (index < word1.length) {
                result.append(word1.substring(index, word1.length))
            }

            if (index < word2.length) {
                result.append(word2.substring(index, word2.length))
            }

            return result.toString()
        }
    }

}