package my.playground.leetcode.kotlin


/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 */
class Task9 {
    fun run() {
        val x = 1999999999
        val reverse = Solution().isPalindrome(x)
        println(reverse)
    }

    /**
     * intuition:
     * if negative sign then false
     * if one number then true?
     * I can mod 10 the x and then x * 10 pow i to construct number in reverse order.
     * I can put original number to array and then compare if digit on 1st position is equal to digit on last position
     */
    class Solution {
//        fun isPalindrome(x: Int): Boolean {
//
//            if (x < 0) {
//                // number has negative sign, so it does not read the same way from both sides
//                return false
//            }
//
//            if (x % 10 == x) {
//                // number has just 1 digit, so it reads the same way from both sides
//                return true
//            }
//
//            // initialize array that is as big as count of digits in max int value
//            val digitArray = IntArray(Int.MAX_VALUE.toString().length)
//
//            //save each digit of integer as element in array
//            var temp = x
//            var i = 0
//            while (temp > 0) {
//                digitArray[i] = temp % 10
//                temp /= 10
//                i++
//            }
//
//            //return index to last occupied array position
//            i--
//
//            //compare if digit from left is equal to digit from right
//            var j = 0
//            while (j < i) {
//                if (digitArray[j] != digitArray[i]) {
//                    return false
//                }
//                j++
//                i--
//            }
//
//            return true
//        }

        fun isPalindrome(x: Int): Boolean {

            if (x < 0) {
                // number has negative sign, so it does not read the same way from both sides
                return false
            }

            if (x % 10 == x) {
                // number has just 1 digit, so it reads the same way from both sides
                return true
            }

            // construct palindrome by taking last digit and adding it to previous result which is multiplied by 10
            var temp = x
            var palindrome = 0L
            while (temp > 0) {
                palindrome = (palindrome * 10) + (temp % 10)
                temp /= 10
            }

            return palindrome.toInt() == x
        }
    }

}