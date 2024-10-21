package com.leetcode.roberto.tasks

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 * Example 2:
 *
 *
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Explanation: There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 * Example 3:
 *
 *
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 * Explanation: There are no exits in this maze.
 *
 *
 * Constraints:
 *
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] is either '.' or '+'.
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance will always be an empty cell.
 */
class Task1926NearestExitFromEntranceInMazeMedium {

    /**
     * example:
     *
     * in:
     * xx-
     * ---
     * xxx
     * 1,1
     *
     * out:
     * 1
     *
     * in
     * xxx-x
     * x---x
     * x-xx-
     * 2,1
     *
     * out:
     * 4
     *
     *
     * intuition:
     *
     * from entrance point, call recursive fuction to every direction where possible.
     * - it is possible to go to direction if:
     * -- is still within maze
     * -- there is no wall
     *
     * - on the location check if:
     * -- it is an exit - there is at least neighbour location that is out of bound
     * --- if yes, mark hop count from entrance - check current minHopCount value and if not -1 or 0 and not higher then stored value, write.
     * --- if no, do nothing
     *
     * recursively call all other neighbour locations.
     *
     *
     * pseudocode:
     *
     * m = I
     * n = ---
     *
     * params:
     * array[m,n]
     * entrance [x,y]
     *
     *
     * findExit(array, posX, posY, hopCnt)
     *
     * currentPos = array[posX, posY) // guaranteed to becan be + or .
     *
     * canEnterLowX = posX -1 > 0
     * canEnterLowY = posY -1 > 0
     * canEnterHighX = posX +1 < array[0].size
     * canEnterHighY = posY +1 < array.size
     *
     *
     * minHopCnt = 0
     *
     * // W
     * if(canEnterLowX)
     * 	minHopCnt = max(findExit(array, posX-1, posY, hopCnt++), minHopCnt)
     *
     * // N
     * if(canEnterLowY)
     * 	minHopCnt = max(findExit(array, posX, posY-1, hopCnt++), minHopCnt)
     *
     * // E
     * if(canEnterHighX)
     * 	minHopCnt = max(findExit(array, posX+1, posY, hopCnt++), minHopCnt)
     *
     * // S
     * if(canEnterHighY)
     * 	minHopCnt = max(findExit(array, posX, posY+1, hopCnt++), minHopCnt)
     *
     *
     * minHopCnt == 0 ? -1 : minHopCnt
     *
     * // is exit
     * if(!canEnterLowX || !canEnterHighX || !canEnterLowY || !canEnterHighY)
     * 	return minHopCnt
     *
     * //TODO evaluate wall
     *
     * return 0
     */
    fun run() {
//        [['+','.','+','+','+','+','+'],
        // ['+','.','+','.','.','.','+'],
        // ['+','.','+','.','+','.','+'],
        // ['+','.','.','.','+','.','+'],
        // ['+','+','+','+','+','.','+']]
        val result = Solution().nearestExit(arrayOf(charArrayOf('+','.','+','+','+','+','+'), charArrayOf('+','.','+','.','.','.','+'), charArrayOf('+','.','+','.','+','.','+'), charArrayOf('+','.','.','.','+','.','+'), charArrayOf('+','+','+','+','+','.','+')), intArrayOf(0, 1))
        println(result)
    }

    class Solution {
        fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {

            val m = maze.size
            val n = maze[0].size

            val queue = ArrayDeque<IntArray>()
            queue.add(intArrayOf(entrance[0], entrance[1], 0))
            maze[entrance[0]][entrance[1]] = '+'

            while (queue.isNotEmpty()) {
                val position = queue.removeFirst()
                val baseX = position[0]
                val baseY = position[1]
                val distance = position[2]

                // represents x,y coordinates of:  north             south              east              west
                val directions = arrayOf(intArrayOf(0,1), intArrayOf(0, -1), intArrayOf(1,0), intArrayOf(-1, 0))

                for (direction in directions) {
                    val x = baseX + direction[0]
                    val y = baseY + direction[1]

                    if (x < 0 || x == m || y < 0 || y == n) continue
                    if (maze[x][y] == '+') continue
                    if (x == 0 || x == m-1 || y == 0 || y == n-1) return distance + 1

                    maze[x][y] = '+'
                    queue.add(intArrayOf(x, y, distance + 1))
                }
            }
            return -1
        }
    }
}