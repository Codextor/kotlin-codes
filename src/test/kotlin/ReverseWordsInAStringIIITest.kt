import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ReverseWordsInAStringIIITest {

    @Test
    fun testReverseWords() {
        val testCases = listOf(
            Pair("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
            Pair("Mr Ding", "rM gniD")
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, reverseWords(input))
        }
    }
}
