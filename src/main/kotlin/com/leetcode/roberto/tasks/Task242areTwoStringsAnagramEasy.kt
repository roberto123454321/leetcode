package com.leetcode.roberto.tasks

class Task242areTwoStringsAnagramEasy {
    fun run() {
        val s = "yqhbicoumu"
        val t = "ouiuycbmqh"

        val result = Solution().isAnagram(s, t)
        println(result)
    }

    class Solution {
        fun isAnagram(s: String, t: String): Boolean {

            if (s.length != t.length) {
                return false
            }

            //init map containing how many occurrences of specific char are in the first string
            val visitedChars : MutableMap<Char, Int> = mutableMapOf()
            for (charInFirstString in s.toCharArray()) {
                if (visitedChars.contains(charInFirstString)) {
                    visitedChars[charInFirstString] = visitedChars[charInFirstString]!! + 1
                } else {
                    visitedChars[charInFirstString] = 1
                }
            }

            //iterate over second string and check if char is in map, in yes decrease occurrence in map, if no = no anagram
            for (charInSecondString in t.toCharArray()) {
                if (visitedChars.containsKey(charInSecondString)) {
                    visitedChars[charInSecondString] = visitedChars[charInSecondString]!! - 1
                    if (visitedChars[charInSecondString] == 0) {
                        visitedChars.remove(charInSecondString)
                    }
                } else {
                    return false
                }
            }

            return true
        }
    }
}