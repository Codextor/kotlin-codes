import kotlin.test.Test
import kotlin.test.assertEquals

class LeastNumberOfUniqueIntegersAfterKRemovalsTest {

    @Test
    fun testFindLeastNumOfUniqueInts() {
        val testCases = listOf(
            Pair(Pair(intArrayOf(5, 5, 4), 1), 1),
            Pair(Pair(intArrayOf(4, 3, 1, 1, 3, 3, 2), 3), 2)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val (arr, k) = input
            val result = findLeastNumOfUniqueInts(arr, k)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
