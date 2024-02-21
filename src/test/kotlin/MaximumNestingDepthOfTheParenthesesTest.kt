import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumNestingDepthOfTheParenthesesTest {

    @Test
    fun testMaxDepth() {
        val testCases = listOf(
            Pair("(1+(2*3)+((8)/4))+1", 3),
            Pair("(1)+((2))+(((3)))", 3)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = maxDepth(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
