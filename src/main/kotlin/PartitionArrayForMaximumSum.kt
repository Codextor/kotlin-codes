/**
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
 * After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning.
 * Test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 *
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 *
 * Input: arr = [1], k = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^9
 * 1 <= k <= arr.length
 * @see <a https://leetcode.com/problems/partition-array-for-maximum-sum/">LeetCode</a>
 */
fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val arraySize = arr.size
    // memoryArray[i] will hold the maximum sum we can get for the first i elements of arr, with memoryArray[0] = 0
    val memoryArray = IntArray(arraySize + 1)

    for (index in 1..arraySize) {
        var subarrayMaxElement = 0
        for (subarraySize in 1..minOf(k, index)) {
            subarrayMaxElement = subarrayMaxElement.coerceAtLeast(arr[index - subarraySize])
            val sum = memoryArray[index - subarraySize] + subarraySize * subarrayMaxElement
            memoryArray[index] = memoryArray[index].coerceAtLeast(sum)
        }
    }
    return memoryArray[arraySize]
}
