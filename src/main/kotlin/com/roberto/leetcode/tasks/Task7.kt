package my.playground.leetcode.kotlin

import kotlin.math.pow

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
class Task7 {
    fun run() {
        val x = -2147483412
        val reverse = Solution().reverse(x)
        println(reverse)
    }

    class Solution {
        fun submittedSolutionReverse(x: Int): Int {
            val revArray: IntArray =
                x.toString().reversed().toCharArray().filter { "-" != it.toString() }.map { it.toString().toInt() }
                    .toIntArray()
            val arrSize = revArray.size

            var i = 0
            var j = arrSize - 1
            var result = 0
            // can be solved by function
            val intMaxDigitNumber = 9

            while (i < arrSize) {

                if (i >= intMaxDigitNumber) {
                    // To check if result is still within integer range:
                    // - We divide by 10 the number that has at least so many digits as int max number.
                    // - Division is made because we do not want to overflow integer.
                    // - Then we multiply it with digit from array.
                    // - Then we add current result to it.
                    // - Finally we compare it with MAX_INT value which is also divided by 10.
                    val numToAdd = (10.0.pow(i.toDouble()).toInt() / 10) * revArray[j]
                    if (numToAdd + (result / 10) > (Int.MAX_VALUE / 10)) {
                        return 0
                    }
                }

                result += revArray[j] * 10.0.pow(i.toDouble()).toInt()
                i++
                j--
            }


            if (x < 0) {
                result *= -1
            }

            return result
        }

        //correct solution
        fun reverse(x: Int): Int {
            var rest = x
            var result = 0

            while (rest != 0) {
                if ((result > (Int.MAX_VALUE / 10)) || (result < (Int.MIN_VALUE / 10))) {
                    return 0
                }
                result = (result * 10) + (rest % 10)
                rest /= 10
            }

            return result
        }
    }
}