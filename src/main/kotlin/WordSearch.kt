/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 * @see <a href="https://leetcode.com/problems/word-search/">LeetCode</a>
 */
fun exist(board: Array<CharArray>, word: String): Boolean {
    val characterCounts = mutableMapOf<Char, Int>()
    for (row in board) {
        for (char in row) {
            characterCounts[char] = characterCounts.getOrDefault(char, 0) + 1
        }
    }
    word.forEach { char ->
        val charCount = characterCounts.getOrDefault(char, 0)
        if (charCount < 1) return false
        characterCounts[char] = charCount - 1
    }

    board.indices.forEach { row ->
        board[0].indices.forEach { col ->
            if (dfs(board, word, row, col, 0)) {
                return true
            }
        }
    }
    return false
}

private fun dfs(board: Array<CharArray>, word: String, row: Int, col: Int, index: Int): Boolean {
    if (index == word.length) return true

    if (row !in 0..board.lastIndex || col !in 0..board[0].lastIndex || board[row][col] != word[index]) return false

    val temp = board[row][col]
    board[row][col] = '/' // mark as visited

    directions.forEach { (dx, dy) ->
        if (dfs(board, word, row + dx, col + dy, index + 1)) {
            return true
        }
    }

    board[row][col] = temp // reset the cell
    return false
}

private val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
