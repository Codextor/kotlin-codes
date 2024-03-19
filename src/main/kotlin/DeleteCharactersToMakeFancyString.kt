/**
 * A fancy string is a string where no three consecutive characters are equal.
 *
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 *
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leeetcode"
 * Output: "leetcode"
 * Explanation:
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 * Example 2:
 *
 * Input: s = "aaabaaaa"
 * Output: "aabaa"
 * Explanation:
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 * Example 3:
 *
 * Input: s = "aab"
 * Output: "aab"
 * Explanation: No three consecutive characters are equal, so return "aab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 * @see <a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string/">LeetCode</a>
 */
fun makeFancyString(s: String): String {
    if (s.length < 3) {
        return s
    }

    val result = StringBuilder()
    var previousChar = ' '
    var repeatCount = 0

    for (currentChar in s) {
        if (currentChar == previousChar) {
            repeatCount++
        } else {
            previousChar = currentChar
            repeatCount = 1
        }
        if (repeatCount < 3) {
            result.append(currentChar)
        }
    }
    return result.toString()
}
