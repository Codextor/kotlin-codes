import kotlin.test.Test
import kotlin.test.assertEquals

class GetEqualSubstringsWithinBudgetTest {

    @Test
    fun testEqualSubstring() {
        val testCases = listOf(
            Pair(Triple("abcd", "bcdf", 3), 3),
            Pair(Triple("abcd", "cdef", 3), 1),
            Pair(Triple("abcd", "acde", 0), 1)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val (s, t, maxCost) = input
            val result = equalSubstring(s, t, maxCost)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
