/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * @see <a href="https://leetcode.com/problems/group-anagrams/">LeetCode</a>
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val resultMap = mutableMapOf<List<Int>, MutableList<String>>()
    strs.forEach { string ->
        val countArray = IntArray(26)
        string.forEach { char ->
            countArray[char - 'a'] += 1
        }
        val key = countArray.toList()
        val currentList = resultMap.getOrDefault(key, mutableListOf())
        currentList.add(string)
        resultMap[key] = currentList
    }
    val resultList = mutableListOf<List<String>>()
    resultMap.values.forEach { listOfString ->
        resultList.add(listOfString)
    }
    return resultList
}
