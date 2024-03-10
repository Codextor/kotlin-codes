import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseSubstringsBetweenEachPairOfParenthesesTest {

    @Test
    fun testReverseParentheses() {
        val testCases = listOf(
            Pair("(abcd)", "dcba"),
            Pair("(u(love)i)", "iloveu"),
            Pair("(ed(et(oc))el)", "leetcode")
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = reverseParentheses(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
