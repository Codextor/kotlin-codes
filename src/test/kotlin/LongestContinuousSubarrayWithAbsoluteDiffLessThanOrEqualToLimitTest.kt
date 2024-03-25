import kotlin.test.Test
import kotlin.test.assertEquals

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

    @Test
    fun testLongestSubarray() {
        val testCases = listOf(
            Triple(intArrayOf(8, 2, 4, 7), 4, 2),
            Triple(intArrayOf(10, 1, 2, 4, 7, 2), 5, 4),
            Triple(intArrayOf(4, 2, 2, 2, 4, 4, 2, 2), 0, 3)
        )

        testCases.forEach { testCase ->
            val (nums, limit, expected) = testCase
            assertEquals(expected, longestSubarray(nums, limit))
        }
    }
}
