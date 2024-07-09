package my.playground.leetcode.kotlin

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
class Task10RegexMatchHard {
    fun run() {
        val s = "abc"
        val p = "a***abc"

        val match = Solution().isMatch(s, p)
        println(match)

    }

////my solution - passed
//    class Solution {
//        fun isMatch(s: String, p: String): Boolean {
//            val stringBuilder = StringBuilder()
//            var isStar = false
//            for (i in p.indices) {
//
//                if (p[i] == '*') {
//                    if (isStar) {
//                        continue
//                    }
//                    isStar = true
//                } else {
//                    isStar = false
//                }
//                stringBuilder.append(p[i])
//
//            }
//            val pFiltered = stringBuilder.toString()
//
//            return try {
//                Pattern.matches(pFiltered, s)
//            } catch (e : PatternSyntaxException) {
//                false
//            }
//        }
//    }

//    correct solution
    class Solution {
        fun isMatch(s: String, p: String): Boolean {

            val resultArray = Array(s.length + 1) {Array(p.length + 1) {false}}

            //empty pattern matches empty string
            resultArray[0][0] = true

            //solve empty string and patterns like a*b* that can match this emtpy string
            for (j in 1 .. p.length) {
                if (p[j - 1] == '*') {
                    resultArray[0][j] = resultArray[0][j - 2]
                }
            }

            for (i in 1 .. s.length) {
                for (j in 1 .. p.length) {
                    // if pattern char matches string char at given position or "."
                    // then look at the result one char back in pattern and in string
                    if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                        resultArray[i][j] = resultArray[i -1][j - 1]
                    }

                    if (p[j - 1] == '*') {
                        //either do not use the star and look at result 2 chars behind in pattern,
                        // or use star and look at the result one char back in string and check if pattern before star equals char in string or is "."
                        resultArray[i][j] =
                            resultArray[i][j - 2] ||
                                    (resultArray[i -1][j] && (p[j - 2] == s[i - 1] || p[j - 2] == '.'))
                    }
                }
            }

            //return most right down result
            return resultArray[s.length][p.length]
        }
    }

}