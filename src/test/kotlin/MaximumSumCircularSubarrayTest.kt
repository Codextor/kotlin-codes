import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MaximumSumCircularSubarrayTest {

    @Test
    fun testMaxSubarraySumCircular() {
        val testCases = listOf(
            Pair(intArrayOf(1, -2, 3, -2), 3),
            Pair(intArrayOf(5, -3, 5), 10),
            Pair(intArrayOf(-3, -2, -3), -2)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, maxSubarraySumCircular(input))
        }
    }
}
