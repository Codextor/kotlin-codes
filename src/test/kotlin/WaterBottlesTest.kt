import kotlin.test.Test
import kotlin.test.assertEquals

class WaterBottlesTest {

    @Test
    fun testNumWaterBottles() {
        val testCases = listOf(
            Triple(9, 3, 13),
            Triple(15, 4, 19)
        )

        testCases.forEach { testCase ->
            val (numBottles, numExchange, expected) = testCase
            val result = numWaterBottles(numBottles, numExchange)
            assertEquals(expected, result, "Expected $expected but got $result for input s=$numBottles, t=$numExchange")
        }
    }
}
