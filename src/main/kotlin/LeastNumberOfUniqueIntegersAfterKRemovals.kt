/**
 * Given an array of integers arr and an integer k.
 * Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * @see <a href="https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/">LeetCode</a>
 */
fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
    val frequencyMap = mutableMapOf<Int, Int>()
    arr.forEach { num ->
        frequencyMap[num] = 1 + frequencyMap.getOrDefault(num, 0)
    }
    val sortedFrequencies = frequencyMap.values.sorted()

    var index = 0
    var removals = k
    while (removals > 0) {
        when {
            sortedFrequencies[index] > removals -> {
                removals = 0
            }
            sortedFrequencies[index] == removals -> {
                removals = 0
                index++
            }
            else -> {
                removals -= sortedFrequencies[index]
                index++
            }
        }
    }
    return sortedFrequencies.size - index
}
