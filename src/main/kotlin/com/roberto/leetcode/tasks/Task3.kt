package my.playground.leetcode.kotlin

import kotlin.math.max

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
class Task3 {
    fun run() {
//        val testString = "asr2 5s"
//        val testString = "abcabcbb"
//        val testString = "pwwkew"
//        val testString = " "
//        val testString = "au"
//        val testString = "dvdf"
        val testString = "abba"

        println("Input string: $testString")

        val result = Solution().lengthOfLongestSubstring(testString)

        println()
        println("Result is: $result")
    }

    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {

            val inputStringLength = s.length
            var longestSubstringLength = 0
            var leftIndex = 0
            val processedChars = mutableSetOf<Char>()

            for (rightIndex in 0 until inputStringLength) {
                if (!processedChars.contains(s[rightIndex])) {
                    processedChars.add(s[rightIndex])
                    longestSubstringLength = max(longestSubstringLength, rightIndex - leftIndex + 1)
                } else {
                    while (processedChars.contains(s[rightIndex])) {
                        processedChars.remove(s[leftIndex])
                        leftIndex++
                    }
                    processedChars.add(s[rightIndex])
                }
            }

            return longestSubstringLength
        }

//    fun lengthOfLongestSubstring(s: String): Int {
//        if (s.isEmpty()) {
//            return 0
//        }
//
//        var longestSubstringLength = 0
//
//        val alreadyProcessedChars = HashMap<Char, Int>()
//        var currentSubstringLength = 0
//        for ((index, char) in s.toCharArray().withIndex()) {
//
//            //abba
//
//            if (alreadyProcessedChars.contains(char)) {
//                if (currentSubstringLength > longestSubstringLength) {
//                    longestSubstringLength = currentSubstringLength
//                }
//
////                for (substringIndex in index downto alreadyProcessedChars[char]) {
////
////                }
//                currentSubstringLength = index - alreadyProcessedChars[char]!! - 1 // -1 because outside this if is done +1
//                println()
//            }
//
//            alreadyProcessedChars[char] = index
//            currentSubstringLength++
//
//            print(char)
//        }
//
//        if (currentSubstringLength > longestSubstringLength) {
//            longestSubstringLength = currentSubstringLength
//        }
//
//        return longestSubstringLength
//    }
    }

}

