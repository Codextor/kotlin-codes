import kotlin.test.Test
import kotlin.test.assertEquals

class WordSearchTest {

    @Test
    fun testExist() {
        val testCases = listOf(
            Triple(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "ABCCED",
                true
            ),
            Triple(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "SEE",
                true
            ),
            Triple(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "ABCB",
                false
            )
        )

        testCases.forEach { testCase ->
            val (board, word, expected) = testCase
            val result = exist(board, word)
            assertEquals(
                expected,
                result,
                "Expected $expected but got $result for board $board and word $word"
            )
        }
    }
}
