/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 * @see <a href="https://leetcode.com/problems/perfect-squares/">LeetCode</a>
 */
fun numSquares(n: Int): Int {
    val resultList = IntArray(n + 1) { Int.MAX_VALUE }
    resultList[0] = 0
    for (index in 1..n) {
        var squareNum = 1
        while (index >= squareNum * squareNum) {
            resultList[index] = minOf(resultList[index], 1 + resultList[index - squareNum * squareNum])
            squareNum++
        }
    }
    return resultList[n]
}
