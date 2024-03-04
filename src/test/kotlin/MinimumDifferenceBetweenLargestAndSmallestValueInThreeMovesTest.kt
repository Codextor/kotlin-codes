import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {

    @Test
    fun testMinDifference() {
        val testCases = listOf(
            Pair(intArrayOf(5, 3, 2, 4), 0),
            Pair(intArrayOf(1, 5, 0, 10, 14), 1),
            Pair(intArrayOf(3, 100, 20), 0),
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = minDifference(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
