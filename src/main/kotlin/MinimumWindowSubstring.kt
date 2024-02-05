/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * @see <a https://leetcode.com/problems/minimum-window-substring/">LeetCode</a>
 */
fun minWindow(s: String, t: String): String {
    val sFrequencyMap = mutableMapOf<Char, Int>()
    val tFrequencyMap = mutableMapOf<Char, Int>()

    t.forEach { char ->
        tFrequencyMap[char] = 1 + tFrequencyMap.getOrDefault(char, 0)
    }

    var start = 0
    var end = 0
    var minWindowStart = 0
    var minWindowLength = Int.MAX_VALUE
    var requiredChars = tFrequencyMap.size

    while (start < s.length && end < s.length) {
        while (end < s.length && requiredChars > 0) {
            val endChar = s[end]
            sFrequencyMap[endChar] = 1 + sFrequencyMap.getOrDefault(endChar, 0)
            if (sFrequencyMap[endChar] == tFrequencyMap[endChar]) {
                requiredChars--
            }
            end++
        }
        if (requiredChars > 0) {
            break
        }
        var startChar = s[start]
        while (!tFrequencyMap.containsKey(startChar) || sFrequencyMap[startChar]!! > tFrequencyMap[startChar]!!) {
            sFrequencyMap[startChar] = sFrequencyMap[startChar]!! - 1
            start++
            startChar = s[start]
        }
        if (end - start < minWindowLength) {
            minWindowLength = end - start
            minWindowStart = start
        }
        sFrequencyMap[startChar] = sFrequencyMap[startChar]!! - 1
        requiredChars++
        start++
    }

    return if (minWindowLength == Int.MAX_VALUE) {
        ""
    } else {
        s.substring(minWindowStart until minWindowStart + minWindowLength)
    }
}
