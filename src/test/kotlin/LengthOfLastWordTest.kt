import kotlin.test.Test
import kotlin.test.assertEquals

class LengthOfLastWordTest {

    @Test
    fun testLengthOfLastWord() {
        val testCases = listOf(
            Pair("Hello World", 5),
            Pair("   fly me   to   the moon  ", 4),
            Pair("luffy is still joyboy", 6),
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = lengthOfLastWord(input)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
