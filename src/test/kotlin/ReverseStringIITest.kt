import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ReverseStringIITest {

    @Test
    fun testReverseStr() {
        val testCases = listOf(
            Triple("abcdefg", 2, "bacdfeg"),
            Triple("abcd", 2, "bacd")
        )

        testCases.forEach { testCase ->
            val (input, k, expected) = testCase
            assertEquals(expected, reverseStr(input, k))
        }
    }
}
