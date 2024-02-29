/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm) with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s[i] is a [printable ascii character](https://en.wikipedia.org/wiki/ASCII#Printable_characters).
 * @see <a href="https://leetcode.com/problems/reverse-string/">LeetCode</a>
 */
fun reverseString(s: CharArray) {
    var tempChar: Char
    var startIndex = 0
    var endIndex = s.lastIndex
    while (startIndex < endIndex) {
        tempChar = s[startIndex]
        s[startIndex] = s[endIndex]
        s[endIndex] = tempChar
        startIndex++
        endIndex--
    }
}
