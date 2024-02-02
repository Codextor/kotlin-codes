/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 * @see <a href="https://leetcode.com/problems/sequential-digits/">LeetCode</a>
 */
fun sequentialDigits(low: Int, high: Int): List<Int> {
    val result = mutableListOf<Int>()
    val lengthOfLow = low.toString().length
    val maxStartDigit = 10 - lengthOfLow
    val numbersQueue = ArrayDeque<Int>()

    for (startDigit in 1..maxStartDigit) {
        var number = startDigit
        for (index in 1 until lengthOfLow) {
            number = number * 10 + startDigit + index
        }
        numbersQueue.add(number)
    }

    while (numbersQueue.isNotEmpty()) {
        val currentNumber = numbersQueue.removeFirst()
        if (currentNumber > high) {
            return result
        }
        if (currentNumber >= low) {
            result.add(currentNumber)
        }
        currentNumber.rem(10).let { lastDigit ->
            if (lastDigit != 9) {
                numbersQueue.add(currentNumber * 10 + lastDigit + 1)
            }
        }
    }
    return result
}
