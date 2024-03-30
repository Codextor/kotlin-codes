/**
 * Given a string s,
 * reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">LeetCode</a>
 */
fun reverseWords(s: String): String {
    val chars = s.toCharArray()

    var start = 0
    chars.forEachIndexed { end, char ->
        if (char.isWhitespace()) {
            reverse(chars, start, end - 1)
            start = end + 1
        }
    }
    reverse(chars, start, chars.lastIndex)
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
