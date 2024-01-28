/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    val prefixSumCount = mutableMapOf<Int, Int>()
    prefixSumCount[0] = 1
    var currentPrefixSum = 0
    var subarraysWithSumK = 0
    for (number in nums) {
        currentPrefixSum += number
        val complement = currentPrefixSum - k
        subarraysWithSumK += prefixSumCount.getOrDefault(complement, 0)
        prefixSumCount[currentPrefixSum] = prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1
    }
    return subarraysWithSumK
}
