import kotlin.test.Test
import kotlin.test.assertEquals

class ContinuousSubarraySumTest {

    @Test
    fun testCheckSubarraySum() {
        val testCases = listOf(
            Triple(intArrayOf(23, 2, 4, 6, 7), 6, true),
            Triple(intArrayOf(23, 2, 6, 4, 7), 6, true),
            Triple(intArrayOf(23, 2, 6, 4, 7), 13, false)
        )

        testCases.forEach { testCase ->
            val (nums, k, expected) = testCase
            val result = checkSubarraySum(nums, k)
            assertEquals(
                expected,
                result,
                "Expected $expected but got $result for input nums=${nums.contentToString()} and k=$k"
            )
        }
    }
}
