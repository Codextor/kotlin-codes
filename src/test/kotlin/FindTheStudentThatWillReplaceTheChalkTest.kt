import kotlin.test.Test
import kotlin.test.assertEquals

class FindTheStudentThatWillReplaceTheChalkTest {

    @Test
    fun testChalkReplacer() {
        val testCases = listOf(
            Triple(intArrayOf(5, 1, 5), 22, 0),
            Triple(intArrayOf(3, 4, 1, 2), 25, 1)
        )

        testCases.forEach { testCase ->
            val (chalk, k, expected) = testCase
            val result = chalkReplacer(chalk, k)
            assertEquals(expected, result, "Failed for chalk: ${chalk.joinToString()} and k: $k")
        }
    }
}
