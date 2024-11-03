package com.leetcode.roberto.tasks

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
class Task17LetterCombinationOfaPhoneNumber {

    fun run() {

        val result = Solution().letterCombinations("23")
        println(result)
    }

    class Solution {
        fun letterCombinations(digits: String): List<String> {
            if (digits.isEmpty()) return emptyList()

            val result = mutableListOf<String>()
            val combinations = StringBuilder()
            val digitToLetters = mapOf(
                Pair('2', "abc"),
                Pair('3', "def"),
                Pair('4', "ghi"),
                Pair('5', "jkl"),
                Pair('6', "mno"),
                Pair('7', "pqrs"),
                Pair('8', "tuv"),
                Pair('9', "wxyz")
            )

            backtrack(0, digits, combinations, digitToLetters, result)

            return result
        }

        private fun backtrack(
            index: Int,
            digits: String,
            combinations: StringBuilder,
            digitToLetters: Map<Char, String>,
            result: MutableList<String>
        ) {
            if (index == digits.length) {
                result.add(combinations.toString())
                return
            }

            val letters = digitToLetters[digits[index]]!!.toCharArray()
            for (letter in letters) {
                combinations.append(letter)
                backtrack(index + 1, digits, combinations, digitToLetters, result)
                combinations.deleteCharAt(index)
            }
        }
    }

}