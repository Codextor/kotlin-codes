import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ReverseIntegerTest {

    @Test
    fun testReverse() {
        val testCases = listOf(
            Pair(123, 321),
            Pair(-123, -321),
            Pair(120, 21)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, reverse(input))
        }
    }
}
