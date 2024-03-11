/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
 * while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessarily unique.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * @see <a href="https://leetcode.com/problems/sort-an-array/">LeetCode</a>
 */
fun sortArray(nums: IntArray): IntArray {
    if (nums.size < 2) return nums
    val auxiliaryArray = IntArray(nums.size)

    fun merge(startIndex: Int, middleIndex: Int, endIndex: Int) {
        for (i in startIndex..endIndex) {
            auxiliaryArray[i] = nums[i]
        }

        var leftPartIndex = startIndex
        var rightPartIndex = middleIndex + 1
        var currentNumsIndex = startIndex

        while (leftPartIndex <= middleIndex && rightPartIndex <= endIndex) {
            if (auxiliaryArray[leftPartIndex] < auxiliaryArray[rightPartIndex]) {
                nums[currentNumsIndex] = auxiliaryArray[leftPartIndex++]
            } else {
                nums[currentNumsIndex] = auxiliaryArray[rightPartIndex++]
            }
            currentNumsIndex++
        }
        while (leftPartIndex <= middleIndex) {
            nums[currentNumsIndex++] = auxiliaryArray[leftPartIndex++]
        }
    }

    fun mergeSort(startIndex: Int, endIndex: Int) {
        if (startIndex < endIndex) {
            val middleIndex = startIndex + (endIndex - startIndex) / 2
            mergeSort(startIndex, middleIndex)
            mergeSort(middleIndex + 1, endIndex)
            merge(startIndex, middleIndex, endIndex)
        }
    }

    mergeSort(0, nums.lastIndex)
    return nums
}
