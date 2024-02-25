/**
 * Given an array of integers arr.
 *
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 *
 * Let's define a and b as follows:
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * Note that ^ denotes the bitwise-xor operation.
 *
 * Return the number of triplets (i, j and k) Where a == b.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,1,6,7]
 * Output: 4
 * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 * Example 2:
 *
 * Input: arr = [1,1,1,1,1]
 * Output: 10
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 * @see <a href="https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">LeetCode</a>
 */
fun countTriplets(arr: IntArray): Int {
    val prefixXorMap = mutableMapOf(0 to (1 to 0))
    var xorSoFar = 0
    var count = 0
    arr.forEachIndexed { index, value ->
        xorSoFar = xorSoFar xor value
        prefixXorMap.getOrDefault(xorSoFar, 0 to 0).let { (first, second) ->
            count += index * first - second
            prefixXorMap[xorSoFar] = first + 1 to second + index + 1
        }
    }
    return count
}
