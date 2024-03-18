/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 * Constraints:
 *
 * 0 <= num <= 10^8
 * @see <a href="https://leetcode.com/problems/maximum-swap/">LeetCode</a>
 */
fun maximumSwap(num: Int): Int {
    if (num < 10) return num

    val digits = num.toString().toCharArray()
    val lastOccurrenceIndex = IntArray(10) { -1 }

    for (index in digits.indices) {
        lastOccurrenceIndex[digits[index] - '0'] = index
    }

    for (index in digits.indices) {
        for (digit in 9 downTo digits[index] - '0' + 1) {
            if (lastOccurrenceIndex[digit] > index) {
                val temp = digits[index]
                digits[index] = digits[lastOccurrenceIndex[digit]]
                digits[lastOccurrenceIndex[digit]] = temp
                return String(digits).toInt()
            }
        }
    }

    return num
}
