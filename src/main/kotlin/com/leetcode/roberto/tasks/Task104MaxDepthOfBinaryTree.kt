package com.leetcode.roberto.tasks

import kotlin.math.max

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
class Task104MaxDepthOfBinaryTree {

    fun run() {
        val ti1 = TreeNode(5)
        val ti21 = TreeNode(5)
        val ti22 = TreeNode(5)
        ti1.left = ti21
        ti1.right = ti22
        val ti31 = TreeNode(5)
        val ti32 = TreeNode(5)
        ti21.left = ti31
        ti21.right = ti32
        val ti33 = TreeNode(5)
        val ti34 = TreeNode(5)
        ti22.left = ti33
        ti22.right = ti34


        val result = Solution().maxDepth(ti1)
        println(result)
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        fun maxDepth(root: TreeNode?): Int {
            // remember depth level
            // go depth first approach
            // if no deeper level, return level
            if (root == null) return 0

            val l = maxDepth(root?.left) + 1
            val r = maxDepth(root?.right) + 1

            return max(l, r)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}