/**
 * You are given an integer array nums of size n and a positive integer k.
 *
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 *
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array.
 * And if there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 *
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * n is a multiple of 3.
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 * @see <a href="https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/">LeetCode</a>
 */
fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    val numsSize = nums.size
    val dividedArraysColumns = 3
    val dividedArraysRows = numsSize / dividedArraysColumns
    val sortedNums = nums.sorted()
    val dividedArrays = Array<IntArray>(dividedArraysRows) { IntArray(dividedArraysColumns) }
    for (index in 0 until numsSize) {
        val row = index / dividedArraysColumns
        val column = index.rem(dividedArraysColumns)
        if (column == 0) {
            dividedArrays[row][column] = sortedNums[index]
        } else if (column == 1 && sortedNums[index] - sortedNums[index - 1] <= k) {
            dividedArrays[row][column] = sortedNums[index]
        } else if (column == 2 && sortedNums[index] - sortedNums[index - 2] <= k) {
            dividedArrays[row][column] = sortedNums[index]
        } else {
            return arrayOf<IntArray>()
        }
    }
    return dividedArrays
}
