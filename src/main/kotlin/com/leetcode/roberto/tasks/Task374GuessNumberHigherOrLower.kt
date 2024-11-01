package com.leetcode.roberto.tasks


class Task374GuessNumberHigherOrLower {

    fun run() {

        val result = Solution().guessNumber(10)
        println(result)
    }

    /**
     * The API guess is defined in the parent class.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * fun guess(num:Int):Int {}
     */

//    class Solution:GuessGame() {
    class Solution() {
//        override fun guessNumber(n:Int):Int {
        fun guessNumber(n:Int):Int {
            if (n == 1) return 1
            var myGuess = n/2
            var step = n/2
            var tryCount = 0
            //there can be at most n tries
            while (tryCount++ <= n) {

//                val result = guess(myGuess)
                val result = 0

                step = step/2
                if(step == 0) step = 1

                if (result == -1) {
                    myGuess -= step
                } else if (result == 1) {
                    myGuess += step
                } else if (result == 0) {
                    return myGuess
                } else {
                    throw IllegalArgumentException("value different than allowed")
                }
            }
            //representing not allowed number
            return 0
        }
    }

}