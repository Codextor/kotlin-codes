/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * @see <a https://leetcode.com/problems/longest-common-subsequence/">LeetCode</a>
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
    if (text1.isEmpty() || text2.isEmpty()) {
        return 0
    }

    val memoryArray = Array<IntArray>(text1.length + 1) { IntArray(text2.length + 1) }

    for (index1 in (0 until text1.length).reversed()) {
        for (index2 in (0 until text2.length).reversed()) {
            val length = if (text1[index1] == text2[index2]) {
                1 + memoryArray[index1 + 1][index2 + 1]
            } else {
                maxOf(memoryArray[index1 + 1][index2], memoryArray[index1][index2 + 1])
            }
            memoryArray[index1][index2] = length
        }
    }
    return memoryArray[0][0]
}
