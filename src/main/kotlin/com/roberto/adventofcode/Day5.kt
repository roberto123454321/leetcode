package com.roberto.adventofcode

class Day5 {

    /**
     * 5208
     */
    fun task1(): Int {

        //load input file to 2 lists - 1st consists of rules, 2nd consists of updates
        val inputLines = loadInputLines("Day5Input.txt")

        var splitIndex = 0
        inputLines.forEachIndexed { index, s -> if (s.isBlank()) splitIndex = index }

        val rules = inputLines.subList(0, splitIndex).map { it.split("|").map { it.toInt() }.toList() }.toList()
        val updates = inputLines.subList(splitIndex + 1, inputLines.size).map{ it.split(",").map { it.toInt() }.toList() }.toList()

        //create map from rules where k is compared number and v is set of nums that must be before k
        val ruleMap = mutableMapOf<Int, Set<Int>>()
        rules.forEach {
            ruleMap.putIfAbsent(it[1], mutableSetOf(it[0]))
            ruleMap.computeIfPresent(it[1]) { _, valueSet -> valueSet.plus(it[0]) }
        }

        //go through every number in update
        //check if it passes every rule
        //if yes, add middle number to result
        var result = 0
        for (update in updates) {
            val updateSet = update.toSet()
            var isPassed = true
            for (i in update.indices) {
                val num = update[i]
                val numsThatMustBeBefore = ruleMap.getOrDefault(num, mutableSetOf()).filter { updateSet.contains(it) }.toSet()
                val actualNumsBefore = update.subList(0, i)
                if (!numsThatMustBeBefore.containsAll(actualNumsBefore)) {
                    isPassed = false
                    break
                }
            }
            if (isPassed) {
                result += update[update.size / 2]
            }
        }
        return result
    }
}