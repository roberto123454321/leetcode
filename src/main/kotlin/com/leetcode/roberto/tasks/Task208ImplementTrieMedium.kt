package com.leetcode.roberto.tasks


/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
class Task208ImplementTrieMedium {
    fun run() {
        val trie = Trie()
        trie.insert("apple")
        println(trie.search("apple")) // true
        println(trie.search("app")) // false
        println(trie.startsWith("app")) // true
        trie.insert("app")
        trie.insert("al")
        trie.insert("c")
        println(trie.search("app")) // true
    }




    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */

    //my solution
    class Trie {

        private val rootNode = Node()

        fun insert(word: String) {
            rootNode.insert(word, 0)
        }

        fun search(word: String): Boolean {
            return rootNode.search(word, 0)
        }

        fun startsWith(prefix: String): Boolean {
            return rootNode.startsWith(prefix, 0)
        }

    }

    class Node {

        private var isEnd = false
        private val nodeArray = arrayOfNulls<Node>(26)

        fun insert(word: String, index: Int) {
            if (word.length < index + 1) return

            //check if at given index is stored a node
            //if yes take out that node and call insert on that node
            //if no create a node and call insert on it
            val letterPosition = word.toCharArray()[index] - 'a'
            var node = nodeArray[letterPosition]
            if (node == null) {
                node = Node()
                nodeArray[letterPosition] = node
            }

            if (word.length == index + 1) {
                node.isEnd = true
            }

            node.insert(word, index + 1)
        }

        fun search(word: String, index: Int): Boolean {
            val letterPosition = word.toCharArray()[index] - 'a'

            if (word.length == index + 1) {
                val node = nodeArray[letterPosition]
                return node != null && node.isEnd
            }

            val node = nodeArray[letterPosition] ?: return false
            return node.search(word, index + 1)
        }

        fun startsWith(prefix: String, index: Int): Boolean {
            val letterPosition = prefix.toCharArray()[index] - 'a'

            if (prefix.length == index + 1) {
                val node = nodeArray[letterPosition]
                return node != null
            }

            val node = nodeArray[letterPosition] ?: return false
            return node.startsWith(prefix, index + 1)
        }
    }


    //copy pasted solution
//    class Trie {
//        var root: Node
//
//        init {
//            root = Node()
//        }
//
//        fun insert(word: String) {
//            root.insert(word, 0)
//        }
//
//        fun search(word: String): Boolean {
//            return root.search(word, 0)
//        }
//
//        fun startsWith(prefix: String): Boolean {
//            return root.startsWith(prefix, 0)
//        }
//
//        inner class Node {
//            var nodes: Array<Node?> = arrayOfNulls(26)
//            var isEnd: Boolean = false
//
//            fun insert(word: String, idx: Int) {
//                if (idx >= word.length) return
//                val i = word[idx].code - 'a'.code
//                if (nodes[i] == null) {
//                    nodes[i] = Node()
//                }
//
//                if (idx == word.length - 1) nodes[i]!!.isEnd = true
//                nodes[i]!!.insert(word, idx + 1)
//            }
//
//            fun search(word: String, idx: Int): Boolean {
//                if (idx >= word.length) return false
//                val node = nodes[word[idx].code - 'a'.code] ?: return false
//                if (idx == word.length - 1 && node.isEnd) return true
//
//                return node.search(word, idx + 1)
//            }
//
//            fun startsWith(prefix: String, idx: Int): Boolean {
//                if (idx >= prefix.length) return false
//                val node = nodes[prefix[idx].code - 'a'.code] ?: return false
//                if (idx == prefix.length - 1) return true
//
//                return node.startsWith(prefix, idx + 1)
//            }
//        }
//    }

}