package com.roberto.adventofcode

import java.io.FileReader
import kotlin.math.abs


class Day1 {
    /**
     * 2769675
     */
    fun countDistance() : Int {
        val (leftList, rightList) = loadInputToList()
        leftList.sort()
        rightList.sort()

        var distance = 0

        for (i in 0 .. leftList.lastIndex) {
            distance += abs(leftList[i] - rightList[i])
        }
        return distance
    }

    /**
     * 24643097
     */
    fun countSimilarityScore(): Int {
        val (leftList, rightList) = loadInputToList()

        var similarity = 0
        val numAppearanceCountMap = rightList.groupingBy { it }.eachCount()
        leftList.filter { numAppearanceCountMap.containsKey(it) }.forEach { similarity += it * numAppearanceCountMap[it]!! }

        return similarity
    }

    private fun loadInputToList(): Pair<MutableList<Int>, MutableList<Int>> {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()
        FileReader("${PATH_TO_INPUT_FILES_DIR}/Day1Input.txt").readLines()
            .asSequence().forEach {
                val nums = it.split("   ")
                leftList.add(nums[0].toInt())
                rightList.add(nums[1].toInt())
            }
        return Pair(leftList, rightList)
    }
}