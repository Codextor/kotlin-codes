/**
 * You are given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any brackets.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 *
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 *
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 * @see <a href="https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/">LeetCode</a>
 */
fun reverseParentheses(s: String): String {
    val openingParenthesesIndices = ArrayDeque<Int>()
    val indexPairs = IntArray(s.length)
    s.forEachIndexed { index, char ->
        if (char == '(') {
            openingParenthesesIndices.add(index)
        } else if (char == ')') {
            val openingParenthesesIndex = openingParenthesesIndices.removeLast()
            indexPairs[openingParenthesesIndex] = index
            indexPairs[index] = openingParenthesesIndex
        }
    }
    val resultBuilder = StringBuilder()
    var currentIndex = 0
    var stepDirection = 1
    while (currentIndex < s.length) {
        if (s[currentIndex] == '(' || s[currentIndex] == ')') {
            currentIndex = indexPairs[currentIndex]
            stepDirection = -stepDirection
        } else {
            resultBuilder.append(s[currentIndex])
        }
        currentIndex += stepDirection
    }

    return resultBuilder.toString()
}
