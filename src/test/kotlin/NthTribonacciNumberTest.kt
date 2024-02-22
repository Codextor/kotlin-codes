import kotlin.test.Test
import kotlin.test.assertEquals

class NthTribonacciNumberTest {

    @Test
    fun testTribonacci() {
        val testCases = listOf(
            Pair(4, 4),
            Pair(25, 1389537)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = tribonacci(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
