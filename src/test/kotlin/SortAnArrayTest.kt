import kotlin.test.Test
import kotlin.test.assertContentEquals

class SortAnArrayTest {

    @Test
    fun testSortArray() {
        val testCases = listOf(
            Pair(intArrayOf(5, 2, 3, 1), intArrayOf(1, 2, 3, 5)),
            Pair(intArrayOf(5, 1, 1, 2, 0, 0), intArrayOf(0, 0, 1, 1, 2, 5))
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertContentEquals(expected, sortArray(input))
        }
    }
}
