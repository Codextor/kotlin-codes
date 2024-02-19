/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/">LeetCode</a>
 */
fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val characterMap = mutableMapOf<Char, Char>()
    val characterSet = mutableSetOf<Char>()
    s.forEachIndexed { index, sChar ->
        val tChar = t[index]
        when {
            characterMap.containsKey(sChar) && characterMap[sChar] != tChar -> return false
            !characterMap.containsKey(sChar) && characterSet.contains(tChar) -> return false
            !characterMap.containsKey(sChar) -> {
                characterMap.put(sChar, tChar)
                characterSet.add(tChar)
            }
        }
    }
    return true
}
