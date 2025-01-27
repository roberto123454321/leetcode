package com.roberto.adventofcode.year2024

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

    fun task2(): Int {

        //load input file to 2 lists - 1st consists of rules, 2nd consists of updates
        val inputLines = loadInputLines("Day5Input.txt")

        var splitIndex = 0
        inputLines.forEachIndexed { index, s -> if (s.isBlank()) splitIndex = index }

        val rules = inputLines.subList(0, splitIndex).map { it.split("|").map { it.toInt() }.toList() }.toList()
        val updates = inputLines.subList(splitIndex + 1, inputLines.size).map{ it.split(",").map { it.toInt() }.toMutableList() }.toList()


        //evaluate if update requires reordering
        val unorderedUpdates = mutableListOf<MutableList<Int>>()
        val ruleMap = mutableMapOf<Int, Set<Int>>()
        rules.forEach {
            ruleMap.putIfAbsent(it[1], mutableSetOf(it[0]))
            ruleMap.computeIfPresent(it[1]) { _, valueSet -> valueSet.plus(it[0]) }
        }
        for (update in updates) {
            val updateSet = update.toSet()
            for (i in update.indices) {
                val num = update[i]
                val numsThatMustBeBefore = ruleMap.getOrDefault(num, mutableSetOf()).filter { updateSet.contains(it) }.toSet()
                val actualNumsBefore = update.subList(0, i)
                if (!numsThatMustBeBefore.containsAll(actualNumsBefore)) {
                    unorderedUpdates.add(update)
                    break
                }
            }
        }


        var result = 0
        for (update in unorderedUpdates) {
            //take each number in update
            //go through every rule and check if both numbers from rule are in update
            // and if rule pass
            //if yes go to next rule
            //if no switch numbers in update and start again

            var isUpdateOrdered = false
            while (!isUpdateOrdered) {
                val numsFromUpdateWithIndexMap = update.withIndex().associate { (index, value) -> value to index }
                var isReordered = false
                for (rule in rules) {
                    if (!update.containsAll(setOf(rule[0], rule[1]))) {
                        continue
                    }

                    val firstNumIndex = numsFromUpdateWithIndexMap[rule[0]]!!
                    val secondNumIndex = numsFromUpdateWithIndexMap[rule[1]]!!

                    //if 1st num is not before 2nd number, rule is not satisfied, and elements need to be switched
                    if (firstNumIndex > secondNumIndex) {
                        val temp = update[firstNumIndex]
                        update[firstNumIndex] = update[secondNumIndex]
                        update[secondNumIndex] = temp

                        //since order in update was changed, break rule validation and start with update evaluation again
                        isReordered = true
                        break
                    }
                }
                // update passed all rules, update is now correctly sorted
                // increase result and continue to next update
                if (!isReordered) {
                    result += update[update.size / 2]
                    isUpdateOrdered = true
                }
            }
        }
        return result
    }

}