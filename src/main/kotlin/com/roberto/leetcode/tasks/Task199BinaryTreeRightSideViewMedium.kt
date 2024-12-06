package com.roberto.leetcode.tasks

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
class Task199BinaryTreeRightSideViewMedium {

    fun run() {
        val root = com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode(1)
        root.left = com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode(2)
        root.right = com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode(3)

        val result = com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution().rightSideView(root)
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

        /**
         * binary tree right side view
         *
         * description:
         * given binary tree. imagine you are standing on the right side of the tree. return numbers you see from top to botton.
         *
         *
         * examples:
         * 1.
         * in:
         *         1
         *    2        3
         * 4     5  6       7
         * out:
         * 1,3,7
         *
         * 2.
         * in:
         * 1,null,3
         * out:
         * 1,3
         *
         * 3.
         * in:
         *        1
         *      2   3
         *     n n 4 n
         * out:
         * 1,3,4
         *
         * 4.
         * in:
         *    1
         *   2   n
         *  3 4 n n
         * out:
         * 1,2,4
         *
         * intuition:
         * travese bin tree BFS recursively. check first right part, then left. on each level mark one most right element.
         *
         *
         */
        fun rightSideView(root: com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode?): List<Int> {
            val rightViewList = mutableListOf<Int>()
            rightSideView(root, 0, rightViewList)
            return rightViewList
        }

        private fun rightSideView(node: com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode?, level: Int, rightViewList: MutableList<Int>) {
            if (node == null) {
                return
            }

            if (rightViewList.size == level) {
                rightViewList.add(node.`val`)
            }

            rightSideView(node.right, level + 1, rightViewList)
            rightSideView(node.left, level + 1, rightViewList)
        }


        class TreeNode(var `val`: Int) {
             var left: com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode? = null
             var right: com.roberto.leetcode.tasks.Task199BinaryTreeRightSideViewMedium.Solution.TreeNode? = null
        }
    }

}