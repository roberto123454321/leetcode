package com.leetcode.roberto.tasks

import java.util.*

/**
 * You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 *
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 * Note:
 *
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 *
 *
 * Example 1:
 *
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".
 * Example 2:
 *
 * Input: s = "erase*****"
 * Output: ""
 * Explanation: The entire string is removed, so we return an empty string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters and stars *.
 * The operation above can be performed on s.
 */
class Task2390RemoveStarsEasy {

    fun run() {

        val result = Solution().removeStars("il**autonrd**cl**nh*up*afpizp****d*a****lst")
        //autonnlst
        // expected: "autonnlst"
        println(result)
    }

    class Solution {
        fun removeStars(s: String): String {
            val stack = Stack<Char>()

            for (i in s.indices) {
                if (s[i] == '*') {
                    stack.pop()
                } else {
                    stack.push(s[i])
                }
            }

            val result = StringBuilder()

            while (stack.isNotEmpty()) {
                result.append(stack.pop())
            }

            return result.reverse().toString()
        }
    }

    //MY SOLUTION - Time Limit Exceeded
    /**
     * examples:
     * 1.
     * in:
     * *always
     * out:
     * lways
     *
     *
     * edge cases:
     * 1.
     * in:
     * *
     * **l
     * out:
     * can not happend - input generated so it is always possible to perform
     *
     *
     * intuition:
     * lets have 2 pointers.
     * first points at non-star char, second points to star.
     * if there are no more stars and 2nd pointer reaches the end of string. finish
     *
     *
     * pseudo code:
     * s = inputString
     * l = 0
     * r = 0
     * result = ''
     * while r < s.size
     *
     * 	if s[r] != *
     * 		r++
     * 		continue
     *
     * 	if s[l] == * && l < r
     * 		l++
     * 		continue
     *
     * 	result = result.replace(s[r], '')
     * 	ir(r>0) r--
     * 	result = inputString.replace(s[l], '')
     * 	if(l>0) l--
     *
     * return result
     *
     * test:
     *
     * in:
     * te*st*
     *
     * expected out:
     * ts
     *
     * L
     *   R
     * st
     * result:st
     *
     *  R
     * L
     * e
     * result:e
     *
     */
//    class Solution {
//        fun removeStars(s: String): String {
//            var r = 0
//            var l = 0
//            var result = LinkedList(s.toList())
//
//            while (r < result.size) {
//                if (result[r] != '*') {
//                    r++
//                    continue
//                }
//
//                l = r-1
//
//                result.removeAt(r)
//                if (r > 0) {
//                    r--
//                }
//                result.removeAt(l)
//                if (l > 0) {
//                    l--
//                }
//            }
//            return result.joinToString("")
//        }
//    }

}