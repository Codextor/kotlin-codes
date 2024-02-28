import kotlin.test.Test
import kotlin.test.assertEquals

class ScoreOfAStringTest {

    @Test
    fun testScoreOfString() {
        val testCases = listOf(
            Pair("hello", 13),
            Pair("zaz", 50)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = scoreOfString(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
