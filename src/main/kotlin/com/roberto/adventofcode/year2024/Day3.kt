package com.roberto.adventofcode.year2024

import java.io.FileReader

/**
 * --- Day 3: Mull It Over ---
 * "Our computers are having issues, so I have no idea if we have any Chief Historians in stock! You're welcome to check the warehouse, though," says the mildly flustered shopkeeper at the North Pole Toboggan Rental Shop. The Historians head out to take a look.
 *
 * The shopkeeper turns to you. "Any chance you can see why our computers are having issues again?"
 *
 * The computer appears to be trying to run a program, but its memory (your puzzle input) is corrupted. All of the instructions have been jumbled up!
 *
 * It seems like the goal of the program is just to multiply some numbers. It does that with instructions like mul(X,Y), where X and Y are each 1-3 digit numbers. For instance, mul(44,46) multiplies 44 by 46 to get a result of 2024. Similarly, mul(123,4) would multiply 123 by 4.
 *
 * However, because the program's memory has been corrupted, there are also many invalid characters that should be ignored, even if they look like part of a mul instruction. Sequences like mul(4*, mul(6,9!, ?(12,34), or mul ( 2 , 4 ) do nothing.
 *
 * For example, consider the following section of corrupted memory:
 *
 * xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
 * Only the four highlighted sections are real mul instructions. Adding up the result of each instruction produces 161 (2*4 + 5*5 + 11*8 + 8*5).
 *
 * Scan the corrupted memory for uncorrupted mul instructions. What do you get if you add up all of the results of the multiplications?
 *
 * --- Part Two ---
 * As you scan through the corrupted memory, you notice that some of the conditional statements are also still intact. If you handle some of the uncorrupted conditional statements in the program, you might be able to get an even more accurate result.
 *
 * There are two new instructions you'll need to handle:
 *
 * The do() instruction enables future mul instructions.
 * The don't() instruction disables future mul instructions.
 * Only the most recent do() or don't() instruction applies. At the beginning of the program, mul instructions are enabled.
 *
 * For example:
 *
 * xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
 * This corrupted memory is similar to the example from before, but this time the mul(5,5) and mul(11,8) instructions are disabled because there is a don't() instruction before them. The other mul instructions function normally, including the one at the end that gets re-enabled by a do() instruction.
 *
 * This time, the sum of the results is 48 (2*4 + 8*5).
 *
 * Handle the new instructions; what do you get if you add up all of the results of just the enabled multiplications?
*/
class Day3 {

    /**
     * 174103751
     */
    fun task1(): Int {
        val input = loadInput()

        val regex = """mul\((-?\d+),(-?\d+)\)""".toRegex()
        val mulOccurrences = regex.findAll(input).map { it.value }.toMutableList()

        var result = 0
        val digitRegex = "(-?\\d+)".toRegex()
//        println(mulOccurrences.size)
        for (mulOccurrence in mulOccurrences) {
            val nums = digitRegex.findAll(mulOccurrence).map { it.value.toInt() }
//                .onEach { println(it) }
                .toMutableList()
            result += (nums[0] * nums[1])
//            println(mulOccurrence)
//            println(nums[0] * nums[1])
//            println(result)
        }

        return result
    }

    /**
     * 100411201
     */
    fun task2(): Int {
        val input = loadInput()
        var result = 0
        var canCount = true

        val regex = """mul\((\d+),(\d+)\)|do\(\)|don't\(\)""".toRegex()
        val matches = regex.findAll(input).map { it.value }.toMutableList()
        for (match in matches) {
            when(match) {
                "do()" -> canCount = true
                "don't()" -> canCount = false
                else -> result += if (canCount) addMul(match) else 0
            }
        }
        return result
    }

    private fun addMul(mul: String): Int {
        val nums = "(\\d+)".toRegex().findAll(mul).map { it.value.toInt() }.toList()
        return nums[0] * nums[1]
    }

    /**
     * 126366575 (high)
     * 82318188 (low)
     * 82759364
     * 126807751 (high)
     * 118986600
     */
//    fun task2(): Long {
//        val inputLines = loadInputLines()
//        var result = 0L
//
//        for (line in inputLines) {
//
//            //from start to first don't()
//            val splittedDonts = line.split("don't()")
//            val allowedBeginningLine = splittedDonts[0]
//            result += countMuls(allowedBeginningLine)
//
//            //from first don't() to last do()
//            val firstDontIndex = line.indexOf("don't()")
//            val lastDoIndex = line.lastIndexOf("do()")
//            val middleLine = line.subSequence(firstDontIndex, lastDoIndex)
//            val betweenDoAndDontRegex = """do\(\).*don't\(\)""".toRegex()
//            val allowedMiddleLine = betweenDoAndDontRegex.findAll(middleLine).joinToString { it.value }
//            result += countMuls(allowedMiddleLine)
//
//            //from last do() to end
//            val splittedDos = line.split("do()")
//            val lastDo = splittedDos[splittedDos.size - 1]
//            val allowedEndingLine = lastDo.split("don't()")[0]
//            result += countMuls(allowedEndingLine)
//        }
//        return result
//    }
//
//    private fun countMuls(input: String): Long {
//
//        val mulRegex = """mul\((-?\d+),(-?\d+)\)""".toRegex()
//        val digitRegex = "(-?\\d+)".toRegex()
//
//        var result = 0L
//        val mulOccurrences = mulRegex.findAll(input).map { it.value }.toMutableList()
////                println(mulOccurrences.size)
//        for (mulOccurrence in mulOccurrences) {
//            val nums = digitRegex.findAll(mulOccurrence).map { it.value.toInt() }
////                    .onEach { println(it) }
//                .toMutableList()
//            result += (nums[0] * nums[1])
////                println(mulOccurrence)
////                println(nums[0] * nums[1])
////                println(result)
//        }
//        return result
//    }

//    private fun loadInputLines(): List<String> {
//        return FileReader("${PATH_TO_INPUT_FILES_DIR}/Day3Input.txt").readLines()
//    }

    private fun loadInput(): String {
        return FileReader("$PATH_TO_INPUT_FILES_DIR/Day3Input.txt").readText()
    }
}