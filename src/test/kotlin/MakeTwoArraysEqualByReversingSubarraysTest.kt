import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MakeTwoArraysEqualByReversingSubarraysTest {

    @Test
    fun testCanBeEqual() {
        val testCases = listOf(
            Pair(Pair(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3)), true),
            Pair(Pair(intArrayOf(7), intArrayOf(7)), true),
            Pair(Pair(intArrayOf(3, 7, 9), intArrayOf(3, 7, 11)), false),
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            val (target, arr) = input
            val result = canBeEqual(target, arr)
            assertEquals(expected, result, "Expected $expected but got $result for input $input")
        }
    }
}
