import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.Test

class ReverseStringTest {

    @Test
    fun testReverseString() {
        val testCases = listOf(
            Pair(charArrayOf('h', 'e', 'l', 'l', 'o'), charArrayOf('o', 'l', 'l', 'e', 'h')),
            Pair(charArrayOf('H', 'a', 'n', 'n', 'a', 'h'), charArrayOf('h', 'a', 'n', 'n', 'a', 'H')),
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            reverseString(input)
            assertArrayEquals(expected, input, "Expected $expected but got $input")
        }
    }
}
