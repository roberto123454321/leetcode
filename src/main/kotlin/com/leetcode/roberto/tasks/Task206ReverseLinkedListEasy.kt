package com.leetcode.roberto.tasks

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
class Task206ReverseLinkedListEasy {
    fun run() {
//        val li1 = ListNode(1)
//        val li2 = ListNode(2)
//        val li3 = ListNode(3)
//        val li4 = ListNode(4)
//        val li5 = ListNode(5)
//
//        li1.next = li2
//        li2.next = li3
//        li3.next = li4
//        li4.next = li5

//        printList(li1)
        val result = Solution().reverseList(null)
        printList(result)
    }

    private fun printList(result: ListNode?) {
        var result1 = result
        while (result1?.`val` != null) {
            print("${result1.`val`} ")
            result1 = result1.next
        }
        println()
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun reverseList(head: ListNode?): ListNode? {
            if (head == null) return head


            val dp = mutableListOf<Int>()
            var node = head

            while (node?.`val` != null) {
                dp.add(node.`val`)
                node = node.next
            }

            val resultHead = ListNode(dp[dp.lastIndex])
            var resultNode : ListNode = resultHead

            for (i in dp.lastIndex - 1 downTo 0) {
                resultNode.next = ListNode(dp[i])
                resultNode = resultNode.next!!
            }

            return resultHead
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

}