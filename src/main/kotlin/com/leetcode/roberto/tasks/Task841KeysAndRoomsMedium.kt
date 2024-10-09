package com.leetcode.roberto.tasks

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * Example 2:
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 *
 *
 * Constraints:
 *
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */
class Task841KeysAndRoomsMedium {


    fun run() {
        val result = Solution().canVisitAllRooms(listOf(listOf(4), listOf(3), listOf(), listOf(2,5,7), listOf(1), listOf(), listOf(8,9), listOf(), listOf(), listOf(6)))
        println(result)
    }


    class Solution {
        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val visitedRooms = BooleanArray(rooms.size)
            visitedRooms[0] = true
            dfs(rooms, visitedRooms, 0)
            return allVisited(visitedRooms)
        }

        private fun allVisited(visitedRooms: BooleanArray): Boolean {
            for (isVisitedRoom in visitedRooms) {
                if (!isVisitedRoom) {
                    return false
                }
            }
            return true
        }

        private fun dfs(rooms: List<List<Int>>, visitedRooms: BooleanArray, roomNumber: Int) {
            for (key in rooms[roomNumber]) {
                    if (!visitedRooms[key]) {
                        visitedRooms[key] = true
                        dfs(rooms, visitedRooms, key)
                    }
            }
        }
    }

    // MY SOLUTION - will not pass [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]], because room 6 is not open
    /**
     * description:
     * given list of rooms. each room has list of keys where each key is represented by integer which tells which room it opens.
     * rooms are from 0 to n, in a way that first element in rooms list represents room 0, second element represents room 1 and so on.
     * at the start, you enter room 0. it is not locked.
     * there are at least 2 rooms.
     * each room does not have the same key twice.
     * n = room number = is from 2 to 1000
     * find out if you can visit every room. return true if yes, othervise false.
     *
     * edge cases:
     * can there be key to room that does not exists? = no.
     *
     * examples:
     *
     * in:
     * [[2],[3],[1]]
     * out:
     * can not happend! 3 is > than n
     *
     * in:
     * [[0,1],[2,1],[]]
     * out:
     * true
     *
     * in:
     * [[1,2],[],[2]]
     * out:
     * true
     *
     * in:
     * [[][]]
     * out:
     * false
     *
     * in:
     * [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
     * out:
     *
     *   t   f   f  f       f   f  f     f  f  f
     *   t   t   t  t       t   t  t     f  f  f
     *
     * pseudocode:
     * use depth first search. -> DO I HAVE TO USE IT? -> yes, because BFS can not be used here
     * create visitedRooms array of size rooms, where each element has value true or false, representing if room was visisted. position in array represents room number.
     * go through each room. for each key in a room check visitedRooms array and check if it was visisted.
     * if no, set to true and go call recursively the function for keys inside the room that was just marked as visited.
     * when all keys in all rooms are processed, check visitedRooms array if all values are true. if yes return true.
     *
     *
     * alternative pseudocode.
     * go through each room. for each key check visitedRooms, if room was visited.
     * BAD: may happend, that key for room 1 is in room 6. so you can not step into room 1 during for loop since you will receive key later.
     */
//    class Solution {
//        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
//            val visitedRooms = BooleanArray(rooms.size)
//            visitedRooms[0] = true
//            for (i in rooms.indices) {
//                for (key in rooms[i]) {
//                    if (key != i && !visitedRooms[key]) {
//                        visitedRooms[key] = true
//                    }
//                }
//            }
//            for (isVisited in visitedRooms) {
//                if (!isVisited) {
//                    return false
//                }
//            }
//            return true
//        }
//    }
}