package my.playground.leetcode.kotlin

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 *
 * Output: 42
 *
 * Explanation:
 *
 * The underlined characters are what is read in and the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * Example 2:
 *
 * Input: s = " -042"
 *
 * Output: -42
 *
 * Explanation:
 *
 * Step 1: "   -042" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -042" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
 *                ^
 * Example 3:
 *
 * Input: s = "1337c0d3"
 *
 * Output: 1337
 *
 * Explanation:
 *
 * Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
 *              ^
 * Example 4:
 *
 * Input: s = "0-1"
 *
 * Output: 0
 *
 * Explanation:
 *
 * Step 1: "0-1" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
 *           ^
 * Example 5:
 *
 * Input: s = "words and 987"
 *
 * Output: 0
 *
 * Explanation:
 *
 * Reading stops at the first non-digit character 'w'.
 *
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
class Task8 {
    fun run() {
        val x = "2147483646"
        val reverse = Solution().myAtoi(x)
        println(reverse)
    }

    /**
     * Intuition:
     *
     * read string from left to right, ignore whitespaces
     *
     * if found sign or digit:
     * - if sign, then remember sign, else sign is +
     * - check next char until not anything different as digit or whitespace, or end of string
     * -- is char function that check if char number is within 0-9 char codes, or whitespace code
     * - if only sign, return 0
     * - convert digits to int, ignore whitespaces
     * -- maybe with continuous multiplication by 10
     * -- if number is not within integer range return INT_MAX or INT_MIN depending on sign
     *
     * if found non-digit (except whitespace) or end of string
     * - return 0
     *
     *
     */
    class Solution {
        fun myAtoi(s: String): Int {

            if (s.isEmpty()) {
                return 0
            }

            val digits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

            if (s.length == 1 && !digits.contains(s[0])) {
                return 0
            }

            var isNegativeSign = false
            var isNumberProcessingStarted = false
            var result = 0
            val chars = s.toCharArray()

            for (i in chars.indices) {
                if (!isNumberProcessingStarted && chars[i] == ' ') {
                    continue
                }

                if (!isNumberProcessingStarted && (chars[i] == '+' || chars[i] == '-' )) {
                    isNegativeSign = chars[i] == '-'
                    isNumberProcessingStarted = true
                    continue
                }

                if (digits.contains(chars[i])) {
                    isNumberProcessingStarted = true

                    //check if not int overflow
                    if (result > (Int.MAX_VALUE - chars[i].toString().toInt()) / 10) {
                        return if (isNegativeSign) Int.MIN_VALUE else Int.MAX_VALUE
                    }

                    //convert digit to int and add it to result
                    result = (result * 10) + chars[i].toString().toInt()
                } else {
                    // no digit character while processing number
                    break
                }
            }

            if (isNegativeSign) {
                result *= -1
            }

            return result
        }
    }
}