package com.roberto.adventofcode

import java.io.FileReader

const val PATH_TO_INPUT_FILES_DIR = "src/main/resources/adventofcode"

fun loadInputLines(fileName: String): List<String> {
    return FileReader("${PATH_TO_INPUT_FILES_DIR}/${fileName}").readLines()
}