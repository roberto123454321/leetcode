package my.playground.leetcode.kotlin


/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 */
class Task6 {
    class Solution {
        fun convert(s: String, numRows: Int): String {

            //array init:

            //array matrix can be divided to repeating rectangles, it has rows = numRows and lines = numRows - 1
            val rectangleLength = if (numRows > 1) { numRows - 1 } else { 1 }
            // count how many characters will one rectangle hold
            val charsInRectangle = (numRows + (rectangleLength - 1))
            // count numbers of rectangles in array matrix
            var rectangleCount = s.length / charsInRectangle
            if (s.length % charsInRectangle != 0) {
                rectangleCount++
            }
            //finally count array length and init array matrix
            val numLines = rectangleLength * rectangleCount
            val array: Array<Array<String>> = Array(numRows) { Array(numLines) { "" } }


            //array filling:

            var sIdx = 0
            var lineIdx = 0
            var rowIdx = 0

            while (sIdx < s.length) {

                //fill row
                while (rowIdx < numRows && sIdx < s.length) {
                    array[rowIdx++][lineIdx] = s[sIdx++].toString()
                }

                if (rowIdx -1 != 0) {
                    rowIdx--
                }

                //fill lines and return back to row 0
                while (rowIdx != 0 && sIdx < s.length) {
                    array[--rowIdx][++lineIdx] = s[sIdx++].toString()
                }
                rowIdx++

            }

//            //debug
//            for (i in 0 until  numRows) {
//                for (j in 0 until numLines) {
//                    print(array[i][j] + " ")
//                }
//                println()
//            }
//            println()


            //convert zigzag array to result string
            val resultString = StringBuilder(s.length)
            for (i in 0 until  numRows) {
                for (j in 0 until numLines) {
                    resultString.append(array[i][j])
                }
            }

            return resultString.toString()
        }
    }

    fun run() {
        val result = Solution().convert("AB", 1)
        println(result)
    }

}