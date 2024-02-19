import kotlin.test.Test
import kotlin.test.assertEquals

class IsomorphicStringsTest {

    @Test
    fun testIsIsomorphic() {
        val testCases = listOf(
            Triple("egg", "add", true),
            Triple("foo", "bar", false),
            Triple("paper", "title", true),
        )

        testCases.forEach { testCase ->
            val (s, t, expected) = testCase
            val result = isIsomorphic(s, t)
            assertEquals(expected, result, "Expected $expected but got $result for input s=$s, t=$t")
        }
    }
}
