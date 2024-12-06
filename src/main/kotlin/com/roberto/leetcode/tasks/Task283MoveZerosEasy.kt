package com.roberto.leetcode.tasks

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */
class Task283MoveZerosEasy {

    fun run() {
        val nums = intArrayOf(-10, 5, 0, 1, 2)
        println(nums.contentToString())
        com.roberto.leetcode.tasks.Task283MoveZerosEasy.Solution().moveZeroes(nums)
        println(nums.contentToString())
    }


    /**
     * in: 0, 1, 2, 3
     * out: 1, 2, 3, 0
     *
     * in: 0, 1, 2, 0, 3, 0
     * out: 1, 2, 3, 0, 0, 0
     *
     * ec:
     * what if no zero? no problem
     * if list empty? can not happend because of task constraints
     *
     * range is? -int max to +int max
     *
     *
     * intuition:
     * we need to go through array from left to right,
     * if element is zero, then move it to the end of array - incorrect - will have to move rest of array 1 position to the left
     * if element is zero, switch with next?
     *
     * ex1:
     * l r
     * 0,1,2,3
     *   l r
     * 1,0,2,3
     *     l r
     * 1,2,0,3
     *       lr
     * 1,2,3,0
     *
     *
     * ex2:
     * l r
     * 0,1,2,0,3,0
     *   l r
     * 1,0,2,0,3,0
     *     l r
     * 1,2,0,0,3,0
     * !!! r should move to next non zero number !!!
     *     l   r
     * 1,2,0,0,3,0
     *       l   r
     * 1,2,3,0,0,0
     *
     *
     * ex3:
     *   l r
     * -10,5,0,1,0,2
     * !!! if l and r are not 0, skip shifting
     *     l   r
     * -10,5,0,1,0,2
     *       l r
     * -10,5,0,1,0,2
     *       l     r
     * -10,5,1,0,0,2
     *         l   r
     * -10,5,1,0,0,2
     *         l   r
     * -10,5,1,2,0,0
     *
     *
     * pseudocode:
     *
     * have 2 pointers l and r
     * l starts from left and moves 1 element to to left
     * r start from l+1 and moves to first non-zero number
     * if l and r have non-zero number, continue
     * if l has zero, switch with r and r moves to next non-zero number
     * if r is at the end of array and there is no more non-zero numbers, finish
     */
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var l = 0
            var r = 0

            while (r < nums.size) {

                if (nums[r] == 0 || r <= l) {
                    r++
                    continue
                }

                if (nums[l] == 0) {
                    nums[l] = nums[r]
                    nums[r] = 0
                }
                l++
            }
        }
    }

}