/**
 * Given a string s and an integer k,
 * reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and leave the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^4
 *
 *
 * @see <a href="https://leetcode.com/problems/reverse-string-ii/">LeetCode</a>
 */
fun reverseStr(s: String, k: Int): String {
    val chars = s.toCharArray()

    var start = 0

    while (start < chars.size) {
        val end = minOf(start + k - 1, chars.lastIndex)
        reverse(chars, start, end)
        start += 2 * k
    }

    return String(chars)
}

private fun reverse(chars: CharArray, start: Int, end: Int) {
    var left = start
    var right = end

    while (left < right) {
        chars[left] = chars[right].also {
            chars[right] = chars[left]
        }
        left++
        right--
    }
}
