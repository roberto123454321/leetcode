package com.leetcode.roberto.tasks

import java.util.*

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 */
class Task275KlargestElementInArrayMedium {

    fun run() {

        val result = Solution().findKthLargest(intArrayOf(6,5,8,4), 3)
        println(result)
    }

    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            val queue = PriorityQueue<Int>()

            for (num in nums) {
                queue.add(num)
                if (queue.size > k) {
                    queue.poll()
                }
            }
            return queue.peek()
        }
    }

    //MY SOLUTION
    //not effective
    /**
     * examples:
     *
     * in:
     * 1,2,3,4,5
     * 3
     * out:
     * 3
     *
     * in:
     * 1,1,1,1,1
     * 5
     * out:
     * 1
     *
     * in:
     *
     * out:
     *
     *
     * edge cases:
     * nums has only 1 element
     * nums has 2 elements
     *
     * intuition:
     * create priority queue of size nums.size.
     * keep track of lowest and highest elements in queue
     * go through nums, and check if
     * - num is bigger than queue top
     * - num is lower than queue bottom
     * - num is lower than queue top but higher than queue bottom
     * based on condition, insert to queue
     * when all nums iterated, take k elements from top of queue.
     *
     * pseudocode:
     * kthLargestElement(nums, k) {
     *   queue = priority queue of size nums.size
     *
     *   for num in nums {
     *     if (num >= queue.top) {
     * 	  queue.addTop(num)
     * 	}
     *
     * 	if (num <= queue.bottom) {
     * 	  queue.addBottom(num)
     * 	}
     *
     * 	if (num > queue.bottom && num > queue.top) {
     * 	  ???
     * 	}
     */

}