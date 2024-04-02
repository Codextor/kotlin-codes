import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MaximumProductSubarrayTest {

    @Test
    fun testMaxProduct() {
        val testCases = listOf(
            Pair(intArrayOf(2, 3, -2, 4), 6),
            Pair(intArrayOf(-2, 0, -1), 0)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, maxProduct(input))
        }
    }
}
