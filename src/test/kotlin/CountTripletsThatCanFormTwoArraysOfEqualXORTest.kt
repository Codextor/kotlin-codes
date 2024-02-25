import kotlin.test.Test
import kotlin.test.assertEquals

class CountTripletsThatCanFormTwoArraysOfEqualXORTest {

    @Test
    fun testCountTriplets() {
        val testCases = listOf(
            Pair(intArrayOf(2, 3, 1, 6, 7), 4),
            Pair(intArrayOf(1, 1, 1, 1, 1), 10)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = countTriplets(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
