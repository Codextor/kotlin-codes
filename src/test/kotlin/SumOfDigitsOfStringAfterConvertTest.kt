import kotlin.test.Test
import kotlin.test.assertEquals

class SumOfDigitsOfStringAfterConvertTest {

    @Test
    fun testGetLucky() {
        val testCases = listOf(
            Triple("iiii", 1, 36),
            Triple("leetcode", 2, 6),
            Triple("zbax", 2, 8)
        )

        testCases.forEach { testCase ->
            val (s, k, expected) = testCase
            assertEquals(expected, getLucky(s, k), "Failed for input: s=$s, k=$k")
        }
    }
}
