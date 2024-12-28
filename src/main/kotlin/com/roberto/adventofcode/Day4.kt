package com.roberto.adventofcode

class Day4 {

    /**
     * 2356 too low
     * 2378
     */
    fun task1(): Int {
        // load input to 2d char array
        val (rows, columns, charArray: Array<Array<Char>>) = load2dArray("Day4Input.txt")

        // go through every char in array
        // check every direction if it does not contain word XMAS
        // skip directions where you can not check all 4 characters
        var matchCount = 0
        for (i in 0 until columns) {
            for (j in 0 until rows) {
                if (charArray[i][j] != 'X') {
                    continue
                }

                //N
                if (i - 3 >= 0 && charArray[i - 1][j] == 'M' && charArray[i - 2][j] == 'A' && charArray[i - 3][j] == 'S') {
                    matchCount++
                }

                //NE
                if (i - 3 >= 0 && j + 3 < rows && charArray[i - 1][j + 1] == 'M' && charArray[i - 2][j + 2] == 'A' && charArray[i - 3][j + 3] == 'S') {
                    matchCount++
                }

                //E
                if (j + 3 < rows && charArray[i][j + 1] == 'M' && charArray[i][j + 2] == 'A' && charArray[i][j + 3] == 'S') {
                    matchCount++
                }

                //SE
                if (i + 3 < columns && j + 3 < rows && charArray[i + 1][j + 1] == 'M' && charArray[i + 2][j + 2] == 'A' && charArray[i + 3][j + 3] == 'S') {
                    matchCount++
                }

                //S
                if (i + 3 < columns && charArray[i + 1][j] == 'M' && charArray[i + 2][j] == 'A' && charArray[i + 3][j] == 'S') {
                    matchCount++
                }

                //SW
                if (i + 3 < columns && j - 3 >= 0 && charArray[i + 1][j - 1] == 'M' && charArray[i + 2][j - 2] == 'A' && charArray[i + 3][j - 3] == 'S') {
                    matchCount++
                }

                //W
                if (j - 3 >= 0 && charArray[i][j - 1] == 'M' && charArray[i][j - 2] == 'A' && charArray[i][j - 3] == 'S') {
                    matchCount++
                }

                //NW
                if (i - 3 >= 0 && j - 3 >= 0 && charArray[i - 1][j - 1] == 'M' && charArray[i - 2][j - 2] == 'A' && charArray[i - 3][j - 3] == 'S') {
                    matchCount++
                }

            }
        }

        return matchCount
    }

    /**
     * 1796
     */
    fun task2(): Int {
        // load input to 2d char array
        val (rows, columns, charArray: Array<Array<Char>>) = load2dArray("Day4Input.txt")

        //go through each char in array until you find A char
        //check boundaries
        //check if line above contains M.M and line below contains S.S and all other combinations
        var matchCount = 0
        for (i in 0 until columns) {
            for (j in 0 until rows) {
                if (charArray[i][j] != 'A') {
                    continue
                }

                if (!(i - 1 >= 0 && i + 1 < columns && j - 1 >= 0 && j + 1 < rows)) {
                    // not within boundaries
                    continue
                }

                matchCount += if(isMatch(charArray, i, j, 'M','M','S','S') ||
                    isMatch(charArray, i, j, 'S','S','M','M') ||
                    isMatch(charArray, i, j, 'M','S','M','S') ||
                    isMatch(charArray, i, j, 'S','M','S','M'))
                    1 else 0
            }
        }


        return matchCount
    }

    private fun isMatch(charArray: Array<Array<Char>>, i: Int, j: Int, nwChar: Char, neChar: Char, swChar: Char, seChar: Char): Boolean {
        return charArray[i - 1][j - 1] == nwChar &&
                charArray[i - 1][j + 1] == neChar &&
                charArray[i + 1][j - 1] == swChar &&
                charArray[i + 1][j + 1] == seChar
    }
}