import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ReverseDegreeTest {

    @Test
    fun testReverseDegree() {
        val testCases = listOf(
            Pair("abc", 148),
            Pair("zaza", 160)
        )

        testCases.forEach { testCase ->
            val (input, expected) = testCase
            assertEquals(expected, reverseDegree(input))
        }
    }
}
