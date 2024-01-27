/**
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
 *
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 * Since the answer can be huge, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.
 * Example 2:
 *
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= k <= 1000
 * @see <a href="https://leetcode.com/problems/k-inverse-pairs-array/">LeetCode</a>
 */
fun kInversePairs(n: Int, k: Int): Int {
    val memoryArray = Array<IntArray>(n + 1) { IntArray(k + 1) { -1 } }
    return numberOfArrays(n, k, memoryArray)
}

fun numberOfArrays(numberOfElements: Int, numberOfInversePairsRequired: Int, memoryArray: Array<IntArray>): Int {
    // since 1 <= numberOfElements, numberOfInversePairsRequired = 0 can only be achieved in one way,
    // by arranging the elements of the array in increasing order
    if (numberOfInversePairsRequired == 0) {
        return 1
    }
    // if numberOfInversePairsRequired is non zero, it cannot be achieved with just one element
    if (numberOfElements == 1 || numberOfInversePairsRequired < 0) {
        return 0
    }
    if (memoryArray[numberOfElements][numberOfInversePairsRequired] != -1) {
        return memoryArray[numberOfElements][numberOfInversePairsRequired]
    }
    var totalNumberOfArrays = 0
    for (numberOfInversePairsEncountered in 0 until numberOfElements) {
        totalNumberOfArrays = (
            totalNumberOfArrays +
                numberOfArrays(
                    numberOfElements - 1,
                    numberOfInversePairsRequired - numberOfInversePairsEncountered,
                    memoryArray
                )
            ).mod(1_00_00_00_007)
    }
    memoryArray[numberOfElements][numberOfInversePairsRequired] = totalNumberOfArrays
    return totalNumberOfArrays
}
