import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumTimeDifferenceTest {

    @Test
    fun testFindMinDifference() {
        val testCases = listOf(
            Pair(listOf("23:59", "00:00"), 1),
            Pair(listOf("00:00", "23:59", "00:00"), 0)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, findMinDifference(input), "Failed for input: $input")
        }
    }
}
