import jdk.internal.joptsimple.internal.Messages.message
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Convert1DArrayInto2DArrayTest {

    @Test
    fun testConstruct2DArray() {
        val testCases = listOf(
            Triple(intArrayOf(1, 2, 3, 4), Pair(2, 2), arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))),
            Triple(intArrayOf(1, 2, 3), Pair(1, 3), arrayOf(intArrayOf(1, 2, 3))),
            Triple(intArrayOf(1, 2), Pair(1, 1), emptyArray<IntArray>())
        )

        testCases.forEach { testCase ->
            val (original, dimensions, expected) = testCase
            val (m, n) = dimensions
            val result = construct2DArray(original, m, n)
            assertEquals(expected.size, result.size, "Failed for original: ${original.contentToString()}, m: $m, n: $n")
            expected.forEachIndexed { index, row ->
                assertContentEquals(row, result[index], "Failed for original: ${original.contentToString()}, m: $m, n: $n")
            }
        }
    }
}
