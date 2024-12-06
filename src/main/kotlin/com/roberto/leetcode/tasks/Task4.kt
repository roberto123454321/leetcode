package my.playground.leetcode.kotlin


/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
class Task4 {

    fun run() {
//        val nums1 = intArrayOf(1, 2, 3, 4, 5)
//        val nums2 = intArrayOf(1, 2, 3, 4, 5)

        val nums1 = intArrayOf(3)
        val nums2 = intArrayOf(-2,-1)

        val result = Solution().findMedianSortedArrays(nums1, nums2)

        println(result)
    }

    class Solution {

//        following solution did not work with following arrays:
//        val nums1 = intArrayOf(3)
//        val nums2 = intArrayOf(-2,-1)
//
//        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//            val longerArray: IntArray
//            val shorterArray: IntArray
//
//            if ((nums1.size != nums2.size) && (nums1.size >= nums2.size)) {
//                longerArray = nums1
//                shorterArray = nums2
//            } else {
//                longerArray = nums2
//                shorterArray = nums1
//            }
//
//            if (longerArray.isEmpty() && shorterArray.isEmpty()) {
//                return 0.0
//            }
//
//            if (longerArray.isEmpty()) {
//                return calculateMedian(shorterArray)
//            }
//
//            if (shorterArray.isEmpty()) {
//                return calculateMedian(longerArray)
//            }
//
//            val mergedArray = IntArray(longerArray.size + shorterArray.size)
//            var mergedArrayIndex = 0
//            for (index in longerArray.indices) {
//
//                if (index + 1 > shorterArray.size) {
//                    mergedArray[mergedArrayIndex++] = longerArray[index]
//                    continue
//                }
//
//                val val1 = longerArray[index]
//                val val2 = shorterArray[index]
//
//                if (val1 < val2) {
//                    mergedArray[mergedArrayIndex++] = val1
//                    mergedArray[mergedArrayIndex++] = val2
//                } else {
//                    mergedArray[mergedArrayIndex++] = val2
//                    mergedArray[mergedArrayIndex++] = val1
//                }
//
//            }
//
//            return calculateMedian(mergedArray)
//        }

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

            if (nums1.isEmpty() && nums2.isEmpty()) {
                return 0.0
            }

            if (nums1.isEmpty()) {
                return calculateMedian(nums2)
            }

            if (nums2.isEmpty()) {
                return calculateMedian(nums1)
            }

            val mergedArray = IntArray(nums1.size + nums2.size)
            val size1 = nums1.size
            val size2 = nums2.size

            var i = 0
            var j = 0
            var k = 0

            while (i < size1 && j < size2) {
                if (nums1[i] <= nums2[j]) {
                    mergedArray[k++] = nums1[i++]
                } else {
                    mergedArray[k++] = nums2[j++]
                }
            }

            while (i < size1) {
                mergedArray[k++] = nums1[i++]
            }

            while (j < size2) {
                mergedArray[k++] = nums2[j++]
            }

            return calculateMedian(mergedArray)
        }

        private fun calculateMedian(mergedArray: IntArray): Double {
            val mergedArraySize = mergedArray.size
            val middleIndex = (mergedArray.size - 1) / 2
            return if (mergedArraySize != 0 && mergedArraySize % 2 == 0) {
                (mergedArray[middleIndex] + mergedArray[middleIndex + 1]) / 2.0
            } else {
                mergedArray[middleIndex].toDouble()
            }
        }
    }
}

