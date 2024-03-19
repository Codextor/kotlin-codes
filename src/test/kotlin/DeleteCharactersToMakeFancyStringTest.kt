import kotlin.test.Test
import kotlin.test.assertEquals

class DeleteCharacterstoMakeFancyStringTest {

    @Test
    fun testMakeFancyString() {
        val testCases = listOf(
            "leeetcode" to "leetcode",
            "aaabaaaa" to "aabaa",
            "aab" to "aab"
        )

        for ((input, expected) in testCases) {
            assertEquals(expected, makeFancyString(input))
        }
    }
}
