package com.roberto.adventofcode.year2024

import java.io.FileReader

const val PATH_TO_INPUT_FILES_DIR = "src/main/resources/adventofcode"

fun loadInputLines(fileName: String): List<String> {
    return FileReader("$PATH_TO_INPUT_FILES_DIR/${fileName}").readLines()
}

fun load2dArray(fileName: String): Triple<Int, Int, Array<Array<Char>>> {
    val inputLines = loadInputLines(fileName)
    val rows = inputLines.size
    val columns = inputLines[0].length
    val charArray: Array<Array<Char>> = Array(columns) { Array(rows) { '\u0000' } }
    inputLines.forEachIndexed { columnIndex, line ->
        line.forEachIndexed { charIndex, char ->
            charArray[columnIndex][charIndex] = char
        }
    }
    return Triple(rows, columns, charArray)
}