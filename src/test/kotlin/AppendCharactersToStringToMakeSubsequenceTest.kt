import kotlin.test.Test
import kotlin.test.assertEquals

class AppendCharactersToStringToMakeSubsequenceTest {

    @Test
    fun testAppendCharacters() {
        val testCases = listOf(
            Pair("coaching", "coding") to 4,
            Pair("abcde", "a") to 0,
            Pair("z", "abcde") to 5
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val (s, t) = input
            val result = appendCharacters(s, t)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
