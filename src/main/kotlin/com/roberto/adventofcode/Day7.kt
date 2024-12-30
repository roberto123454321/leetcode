package com.roberto.adventofcode

class Day7 {
    /**
     * 3245122495150
     */
    fun task1(): Long {
        /**
         * load input text:
         * - load lines
         * -- separate by :
         * -- before semicolumn is result
         * -- after semicolumn are numbers
         * --- divide string by " " and store to list
         */
        val inputLines = loadInputLines("Day7Input.txt")
        val resultWithNumbersPairs = mutableListOf<Pair<Long, List<Int>>>()
        for (line in inputLines) {
            val splitLine = line.split(":")
            val expectedResult = splitLine[0].toLong()
            val numbers = splitLine[1].drop(1).split(" ").map { it.toInt() }.toList()
            resultWithNumbersPairs.add(Pair(expectedResult, numbers))
        }

        /**
         * for every pair of result and numbers do
         * - try every combination of operators between numbers
         * -- for numbers: 1 2 3 there are 4 possible combinations:
         * --- 1+2+3
         * --- 1*2*3
         * --- 1+2*3
         * --- 1*2+3
         * - check if combination is equal to result
         * -- if yes add result to resultsAddition
         *
         */
        var result = 0L
        for (resultNumbersPair in resultWithNumbersPairs) {
            val numbersCount = resultNumbersPair.second.size
            val operators = generateOperators(numbersCount)

            if (canExpectedResultBeCalculated(resultNumbersPair, operators)) {
                result += resultNumbersPair.first
            }
        }

        return result
    }

    private fun canExpectedResultBeCalculated(resultNumbersPair: Pair<Long, List<Int>>, operators: MutableList<String>): Boolean {
        val expectedResult = resultNumbersPair.first
        val numbers = resultNumbersPair.second
        for (operator in operators) {
            val countedNumber = evalNum(numbers, operator.toList())
            if (countedNumber == expectedResult) {
                return true
            }
        }
        return false
    }

    private fun evalNum(
        numbers: List<Int>,
        operators: List<Char>
    ): Long {
        if (numbers.isEmpty()) {
            throw IllegalArgumentException("no numbers")
        }

        if (numbers.size == 1) {
            return numbers[0].toLong()
        }

        var result = numbers[0].toLong()
        for (i in 1 until numbers.size) {
            when (operators[i - 1]) {
                '+' -> result += numbers[i]
                '*' -> result *= numbers[i]
                else -> throw IllegalArgumentException("Unknown operator $operators")
            }
        }
        return result
    }

    private fun generateOperators(numbersCount: Int): MutableList<String> {
        if (numbersCount < 2) {
            throw IllegalArgumentException("At least 2 numbers are required")
        }

        val operators = mutableListOf<String>()
        generateOperators(0, "", listOf("+", "*"), numbersCount, operators)
        return operators
    }

    private fun generateOperators(depth: Int, result: String, operators: List<String>, numbersCount: Int, results: MutableList<String>) {
        if (depth == numbersCount - 1) {
            results.add(result)
            return
        }

        for (operator in operators) {
            generateOperators(depth + 1, "$result$operator", operators, numbersCount, results)
        }

    }
}