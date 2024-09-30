package com.leetcode.roberto.tasks

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
 * Example 2:
 *
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 *
 */
class Task2215FindDiffOf2Arrays {

    fun run() {

        val input1 = intArrayOf(1,2,3)
        val input2 = intArrayOf(2,3,4)
        val result = Solution().findDifference(input1, input2)
        println(result)
    }

    /**
     * description:
     * given 2 arrays, return list of size 2, where
     * 1element is list of numbers from input list 1 that are not included in input list 2 and
     * element2 is list containing numbers from input list 2 that are not present in list 1
     *
     * examples:
     *
     * 1.
     * in:
     * [1,2,3] [2,3,4]
     *
     * out:
     * [[1],[4]]
     *
     * 2.
     * [-1000, 0, 6] [1]
     * [-1000, 0, 6] [1]
     *
     * 3.
     * [1,1,1] []
     * [1] []
     *
     *
     * edge cases:
     * what to return if both input lists contain the same values?
     * two empty lists?
     *
     *
     * intuition:
     * convert both lists to sets
     * call some function on set1.somefunction(set2) to return elements which are not in set2 = notInSet2
     * call the same function on set2 = notInSet1
     * return list [notInSet1,notInSet2]
     *
     * pseodocode:
     *
     * class Solution {
     *     fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
     *         val set1 = nums1.toset()
     *         val set2 = nums2.toset()
     * 		val notInSet2 = set1.somefunction(set2)
     * 		val notInSet1 = set2.somefunction(set1)
     * 		return listOf(notInSet1.toList(), notInSet2.toList())
     *     }
     * }
     */
    class Solution {
        fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
            val set1 = nums1.toHashSet()
            val set2 = nums2.toHashSet()
            val notInSet1 = set1.minus(set2)
            val notInSet2 = set2.minus(set1)
            return listOf(notInSet1.toList(), notInSet2.toList())
        }
    }

}