package my.playground.leetcode.kotlin


/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class Task5 {

    fun run() {
//        val s = "abaeeccccef"
        val s = "aacabdkacaa"
        val result = Solution().longestPalindrome(s)
        println(result)
    }

    class Solution {
        /**
         * better solution would be to choose center letter and look on the L and R sides of letter if it has the same character.
         *
         * My submitted working solution:
         * Going from left and right corner of string to the center and check if chars are the same.
         * Right pointer is going to the left towards the left pointer,
         *   while checking if chars on which pointers are pointing are the same.
         * If left and right pointers meet, we have a longest palindrome,
         * if on the way pointers do not point to the same character, move pointers and start again.
         */
        fun longestPalindrome(s: String): String {

            var longestPalindrome = ""

            for (leftBoundary in 0 until s.length) {
                var cnt = 0

                for (rightBoundary in s.length - 1 downTo leftBoundary) {

                    do {

                        if (s[leftBoundary + cnt] != s[rightBoundary - cnt]) {
                            cnt = 0
                            continue
                        }

                        if ((leftBoundary + cnt) >= (rightBoundary - cnt)) {
                            val palindrome = s.substring(leftBoundary, rightBoundary + 1)
                            if (palindrome.length > longestPalindrome.length) {
                                longestPalindrome = palindrome
                            }
                            cnt = 0
                            continue
                        }
                        cnt++

                    } while (cnt > 0)
                }

            }
            return longestPalindrome
        }
    }
}

            //fails on aacabdkacaa
//        fun longestPalindrome(s: String): String {
//            val rev = s.reversed()
//            var longestSubstring = ""
//
//            for (i in 0 until s.length) {
//                val letter = s[i]
//                var cnt = 0
//                print("i: $i letter: $letter ")
//
//                for (j in 0 until rev.length) {
//
//                    if (letter != rev[j] && cnt == 0) {
//                        continue
//                    }
//
//                    // char is within string range & compared chars are equal
//                    if (j < s.length && i + cnt < s.length && s[i + cnt] == rev[j]) {
//                        cnt++
//                    } else {
//                        cnt = 0
//                    }
//
//                    if (longestSubstring.length <= cnt) {
//                        longestSubstring = s.substring(i, i + cnt)
//                    }
//
//                }
//            }
//
//            return longestSubstring
//        }

