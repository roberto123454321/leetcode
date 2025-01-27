package com.roberto.adventofcode.year2024

private const val MAX_STEPS_COUNT = 50_000

class Day6 {

    /**
     * 1789
     */
    fun task2(): Int {
        //load input to 2d array map
        val (rows, columns, charArray: Array<Array<Char>>) = load2dArray("Day6Input.txt")

        var startI = 0
        var startJ = 0
        for (i in 0 until columns) {
            for (j in 0 until rows) {
                if (charArray[i][j] == '^') {
                    startI = i
                    startJ = j
                    charArray[i][j] = 'X'
                }
            }
        }

        //make a function that count number of moves needed to get out from map.
        //however on every move it tries to construct alternative route and check if it will cause infinite loop
        //so if guard steps on "." then execute alternative function that check if infinite loop is caused
        return countInfiniteLoops(startI, startJ, charArray, rows, columns)
    }

    private fun countInfiniteLoops(
        startI: Int, startJ: Int,
        charArray: Array<Array<Char>>,
        rows: Int, columns: Int,
    ): Int {
        var loopsCounter = 0
        var direction = Direction('N')
        var i = startI
        var j = startJ

        while (true) {
            if (i < 0 || i >= rows || j < 0 || j >= columns) {
                //border hit
                break
            }

            if (charArray[i][j] == '.') {
                val charCopy = deepCopy(charArray)
                charCopy[i][j] = '#'
                loopsCounter += countAlternativePath(direction, i, j, charCopy, rows, columns)

                val (newI, newJ) = direction.move(i, j)
                charArray[i][j] = 'X'
                i = newI
                j = newJ
                continue
            }

            if (charArray[i][j] == 'X') {
                val (newI, newJ) = direction.move(i, j)
                i = newI
                j = newJ
                continue
            }

            if (charArray[i][j] == '#') {
                val (newI, newJ) = direction.moveBack(i, j)
                i = newI
                j = newJ
                direction = direction.turn()
                continue
            }
        }
        return loopsCounter
    }

    private fun countAlternativePath(
        startDirection: Direction,
        startI: Int, startJ: Int,
        charArray: Array<Array<Char>>,
        rows: Int, columns: Int,
    ): Int {
        var direction = startDirection
        var moveCounter = 1
        var i = startI
        var j = startJ

        while (true) {
            if (moveCounter > MAX_STEPS_COUNT) {
                return 1
            }

            if (i < 0 || i >= rows || j < 0 || j >= columns) {
                //border hit
                break
            }

            if (charArray[i][j] == '.') {
                val (newI, newJ) = direction.move(i, j)
                charArray[i][j] = 'X'
                i = newI
                j = newJ
                moveCounter++
                continue
            }

            if (charArray[i][j] == 'X') {
                val (newI, newJ) = direction.move(i, j)
                i = newI
                j = newJ
                moveCounter++
                continue
            }

            if (charArray[i][j] == '#') {
                val (newI, newJ) = direction.moveBack(i, j)
                i = newI
                j = newJ
                direction = direction.turn()
                continue
            }
        }
        return 0
    }

    private fun deepCopy(original: Array<Array<Char>>): Array<Array<Char>> {
        val deepCopy: Array<Array<Char>> = Array(original.size) { Array(original[it].size) { '\u0000' } }

        for (i in original.indices) {
            for (j in original[i].indices) {
                deepCopy[i][j] = original[i][j]
            }
        }
        return deepCopy
    }

    /**
     * 4967
     */
    fun task1(): Int {
        //load input to 2d array map
        val (rows, columns, charArray: Array<Array<Char>>) = load2dArray("Day6Input.txt")

        var startI = 0
        var startJ = 0
        for (i in 0 until columns) {
            for (j in 0 until rows) {
                if (charArray[i][j] == '^') {
                    startI = i
                    startJ = j
                    charArray[i][j] = 'X'
                }
            }
        }

        //make a recursive function that will finish once map borders are hit
        //function will do:
        // - at start, face north
        // - move 1 step until next step will be #
        // - when moved, mark current position with X and increase moveCounter
        // -- if next position is X, move forward, but does not increase moveCounter
        // -- if next position is #, turn 90degrees right, so if you are facing north, you will be facing east
        // - when borders are hit, return moveCounter
        return countMoves(startI, startJ, charArray, rows, columns)
    }

    private fun countMoves(
        startI: Int, startJ: Int,
        charArray: Array<Array<Char>>,
        rows: Int, columns: Int,
    ): Int {

        var moveCounter = 1
        var direction = Direction('N')
        var i = startI
        var j = startJ

        while (true) {
            if (i < 0 || i >= rows || j < 0 || j >= columns) {
                //border hit
                break
            }

            if (charArray[i][j] == '.') {
                val (newI, newJ) = direction.move(i, j)
                charArray[i][j] = 'X'
                i = newI
                j = newJ
                moveCounter++
                continue
            }

            if (charArray[i][j] == 'X') {
                val (newI, newJ) = direction.move(i, j)
                i = newI
                j = newJ
                continue
            }

            if (charArray[i][j] == '#') {
                val (newI, newJ) = direction.moveBack(i, j)
                i = newI
                j = newJ
                direction = direction.turn()
                continue
            }
        }

        return moveCounter
    }

    /**
     * Exception in thread "main" java.lang.StackOverflowError
     */
//    private fun countMoves(
//        y: Int, x: Int,
//        direction: Direction,
//        charArray: Array<Array<Char>>,
//        rows: Int, columns: Int,
//        moveCounter: Int
//    ): Int {
//        if (y < 0 || y >= rows || x < 0 || x >= columns) {
//            //border hit
//            return moveCounter
//        }
//
//        if (charArray[y][x] == '.') {
//            charArray[y][x] = 'X'
//            val (newY, newX) = direction.move(y, x)
//            return countMoves(newY, newX, direction, charArray, rows, columns, moveCounter + 1)
//        }
//
//        if (charArray[y][x] == 'X') {
//            val (newY, newX) = direction.move(y, x)
//            return countMoves(newY, newX, direction, charArray, rows, columns, moveCounter)
//        }
//
//        if (charArray[y][x] == '#') {
//            val (newY, newX) = direction.moveBack(y, x)
//            return countMoves(newY, newX, direction.turn(), charArray, rows, columns, moveCounter)
//        }
//
//        throw IllegalStateException()
//    }

    class Direction(val current: Char) {

        fun turn(): Direction {
            return when(current) {
                'N' -> Direction('E')
                'E' -> Direction('S')
                'S' -> Direction('W')
                'W' -> Direction('N')
                else -> throw IllegalArgumentException()
            }
        }

        fun move(i: Int, j: Int): Pair<Int, Int> {
            return when(current) {
                'N' -> Pair(i - 1, j)
                'E' -> Pair(i, j + 1)
                'S' -> Pair(i + 1, j)
                'W' -> Pair(i, j - 1)
                else -> throw IllegalArgumentException()
            }
        }

        fun moveBack(i: Int, j: Int): Pair<Int, Int> {
            return when(current) {
                'N' -> Pair(i + 1, j)
                'E' -> Pair(i, j - 1)
                'S' -> Pair(i - 1, j)
                'W' -> Pair(i, j + 1)
                else -> throw IllegalArgumentException()
            }
        }
    }

}
