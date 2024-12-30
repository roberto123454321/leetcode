package com.roberto.adventofcode

private const val INPUT_FILE = "Day7Input.txt"

class Day7 {

    /**
     * 105517128211543
     */
    fun task2(): Long {
        val resultWithNumbersPairs = loadInputToResultWithNumbersPairs()
        var result = 0L
        for (resultNumbersPair in resultWithNumbersPairs) {
            val numbersCount = resultNumbersPair.second.size
            val operators = generateOperators(numbersCount, listOf("+", "*", "|"))

            if (canExpectedResultBeCalculated(resultNumbersPair, operators)) {
                result += resultNumbersPair.first
            }
        }

        return result
    }

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
        val resultWithNumbersPairs = loadInputToResultWithNumbersPairs()

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
            val operators = generateOperators(numbersCount, listOf("+", "*"))

            if (canExpectedResultBeCalculated(resultNumbersPair, operators)) {
                result += resultNumbersPair.first
            }
        }

        return result
    }

    private fun loadInputToResultWithNumbersPairs(): MutableList<Pair<Long, List<Int>>> {
        val inputLines = loadInputLines(INPUT_FILE)
        val resultWithNumbersPairs = mutableListOf<Pair<Long, List<Int>>>()
        for (line in inputLines) {
            val splitLine = line.split(":")
            val expectedResult = splitLine[0].toLong()
            val numbers = splitLine[1].drop(1).split(" ").map { it.toInt() }.toList()
            resultWithNumbersPairs.add(Pair(expectedResult, numbers))
        }
        return resultWithNumbersPairs
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
                '|' -> result = "$result${numbers[i]}".toLong()
                else -> throw IllegalArgumentException("Unknown operator $operators")
            }
        }
        return result
    }

    private fun generateOperators(numbersCount: Int, inputOperators: List<String>): MutableList<String> {
        if (numbersCount < 2) {
            throw IllegalArgumentException("At least 2 numbers are required")
        }

        val generatedOperators = mutableListOf<String>()
        generateOperators(0, "", inputOperators, numbersCount, generatedOperators)
        return generatedOperators
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