import kotlin.test.Test
import kotlin.test.assertEquals

class SingleNumberIIITest {

    @Test
    fun testSingleNumber() {
        val testCases = listOf(
            Pair(intArrayOf(1, 2, 1, 3, 2, 5), intArrayOf(3, 5)),
            Pair(intArrayOf(-1, 0), intArrayOf(-1, 0)),
            Pair(intArrayOf(0, 1), intArrayOf(1, 0)),
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val result = singleNumber(input)
            assertEquals(expected.sorted(), result.sorted(), "Expected $expected but got $result for input $input")
        }
    }
}
