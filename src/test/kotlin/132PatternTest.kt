import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class `132PatternTest` {

    @Test
    fun testFind132pattern() {
        val testCases = listOf(
            Pair(intArrayOf(1, 2, 3, 4), false),
            Pair(intArrayOf(3, 1, 4, 2), true),
            Pair(intArrayOf(-1, 3, 2, 0), true)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, find132pattern(input))
        }
    }
}
