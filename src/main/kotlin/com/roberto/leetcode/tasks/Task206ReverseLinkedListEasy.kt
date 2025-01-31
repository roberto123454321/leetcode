package com.roberto.leetcode.tasks

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
        val li1 = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(1)
        val li2 = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(2)
        val li3 = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(3)
        val li4 = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(4)
        val li5 = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(5)

        li1.next = li2
        li2.next = li3
        li3.next = li4
        li4.next = li5

        printList(li1)
        val result = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.Solution().reverseList(li1)
        printList(result)
    }

    private fun printList(result: com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode?) {
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
        fun reverseList(head: com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode?): com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode? {
            if (head == null) return head
            if (head.next == null) return head

            var inputList: com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode = head

            //first construct last node of output list
            var previousNode = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(inputList.`val`)
            previousNode.next = null

            var newNode: com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode? = null
            //while there are next elements in input linked list
            while (inputList.next != null) {
                //construct newNode where node.value is next value from input linked list and node.next is previousNode
                newNode = com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode(inputList.next!!.`val`)
                newNode.next = previousNode

                //previousNode in next loop iteration will be current newNode
                previousNode = newNode

                //proceed to next element in input linked list
                inputList = inputList.next!!
            }

            //return lastly constructed newNode which is first element of output list
            return newNode
        }
    }

    //my solution
//    class Solution {
//        fun reverseList(head: ListNode?): ListNode? {
//            if (head == null) return head
//
//
//            val dp = mutableListOf<Int>()
//            var node = head
//
//            while (node?.`val` != null) {
//                dp.add(node.`val`)
//                node = node.next
//            }
//
//            val resultHead = ListNode(dp[dp.lastIndex])
//            var resultNode : ListNode = resultHead
//
//            for (i in dp.lastIndex - 1 downTo 0) {
//                resultNode.next = ListNode(dp[i])
//                resultNode = resultNode.next!!
//            }
//
//            return resultHead
//        }
//    }


    class ListNode(var `val`: Int) {
        var next: com.roberto.leetcode.tasks.Task206ReverseLinkedListEasy.ListNode? = null
    }

}