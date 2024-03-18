import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumSwapTest {

    @Test
    fun testMaximumSwap() {
        val testCases = listOf(
            Pair(2736, 7236),
            Pair(9973, 9973)
        )

        for ((input, expected) in testCases) {
            assertEquals(expected, maximumSwap(input))
        }
    }
}
