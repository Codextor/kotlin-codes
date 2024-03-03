import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IntersectionOfTwoArraysIITest {

    @Test
    fun testIntersect() {
        val testCases = listOf(
            Pair(Pair(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)), intArrayOf(2, 2)),
            Pair(Pair(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)), intArrayOf(4, 9))
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val (num1, num2) = input
            val result = intersect(num1, num2).sortedArray()
            assertEquals(
                expected.sortedArray().toList(),
                result.toList(),
                "Expected ${expected.toList()} but got ${result.toList()} for input $input"
            )
        }
    }
}
