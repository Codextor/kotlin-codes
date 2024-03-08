import kotlin.test.Test
import kotlin.test.assertEquals

class PassThePillowTest {

    @Test
    fun testPassThePillow() {
        val testCases = listOf(
            Triple(4, 5, 2),
            Triple(3, 2, 3)
        )

        testCases.forEach { testCase ->
            val (n, time, expected) = testCase
            val result = passThePillow(n, time)
            assertEquals(expected, result, "Expected $expected but got $result for input s=$n, t=$time")
        }
    }
}
