/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^5
 * s consists of uppercase and lowercase English letters and digits.
 * @see <a href="https://leetcode.com/problems/sort-characters-by-frequency/">LeetCode</a>
 */
fun frequencySort(s: String): String {
    val frequencyMap = mutableMapOf<Char, Int>()
    s.forEach { char ->
        frequencyMap[char] = 1 + frequencyMap.getOrDefault(char, 0)
    }
    val charsByFrequencyMap = mutableMapOf<Int, MutableList<Char>>()
    frequencyMap.forEach { char, frequency ->
        if (!charsByFrequencyMap.contains(frequency)) {
            charsByFrequencyMap[frequency] = mutableListOf(char)
        } else {
            charsByFrequencyMap[frequency]?.add(char)
        }
    }
    val result = StringBuilder()
    for (frequency in s.length downTo 1) {
        charsByFrequencyMap[frequency]?.forEach { char ->
            repeat(frequency) {
                result.append(char)
            }
        }
    }
    return result.toString()
}
