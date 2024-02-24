import kotlin.test.Test
import kotlin.test.assertEquals

class NumberOfStepsToReduceANumberInBinaryRepresentationToOneTest {

    @Test
    fun testNumSteps() {
        val testCases = listOf(
            Pair("1101", 6),
            Pair("10", 1),
            Pair("1", 0)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = numSteps(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
