/**
 * Given an integer array nums, find a
 *
 * that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * @see <a href="https://leetcode.com/problems/maximum-product-subarray/">LeetCode</a>
 */
fun maxProduct(nums: IntArray): Int {
    var currentMax = 1
    var currentMin = 1
    var maxProduct = Int.MIN_VALUE

    nums.forEach { num ->
        val prod1 = currentMax * num
        val prod2 = currentMin * num
        currentMax = maxOf(num, prod1, prod2)
        currentMin = minOf(num, prod1, prod2)
        maxProduct = maxOf(maxProduct, currentMax)
    }
    return maxProduct
}
