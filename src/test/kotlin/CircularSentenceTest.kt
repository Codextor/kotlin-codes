import kotlin.test.Test
import kotlin.test.assertEquals

class CircularSentenceTest {

    @Test
    fun testIsCircularSentence() {
        val testCases = listOf(
            "leetcode exercises sound delightful" to true,
            "eetcode" to true,
            "Leetcode" to false
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = isCircularSentence(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
