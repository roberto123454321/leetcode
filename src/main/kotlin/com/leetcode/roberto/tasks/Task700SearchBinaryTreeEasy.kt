package com.leetcode.roberto.tasks

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
class Task700SearchBinaryTreeEasy {

    fun run() {
        val ti1 = TreeNode(4)
        val ti21 = TreeNode(2)
        val ti22 = TreeNode(7)
        ti1.left = ti21
        ti1.right = ti22
        val ti31 = TreeNode(1)
        val ti32 = TreeNode(3)
        ti21.left = ti31
        ti21.right = ti32

        val result = Solution().searchBST(ti1, 7)

        printResult(result)

    }

    private fun printResult(result: TreeNode?) {
        if (result == null) return
        print("${result.`val`} ")
        printResult(result.left)
        printResult(result.right)
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     * var left: TreeNode? = null
     * var right: TreeNode? = null
     * }
     */
    class Solution {
        //resursive solution
//        fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
//            // search for val
//            // if root.val is < than val, traverse left node, otherwise right
//            // if root.val = val return
//
//            if (root == null) return null
//
//            if (root.`val` == `val`) return root
//
//            if (root.`val` > `val`) return searchBST(root.left, `val`) else return searchBST(root.right, `val`)
//        }

        fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
            var currentNode = root

            while (currentNode != null && currentNode.`val` != `val`) {
                currentNode = if (`val` < currentNode.`val`) currentNode.left else currentNode.right
            }
            return currentNode
        }

    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}