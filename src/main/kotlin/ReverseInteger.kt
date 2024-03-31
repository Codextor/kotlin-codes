/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 *
 *
 * @see <a href="https://leetcode.com/problems/reverse-integer/">LeetCode</a>
 */
fun reverse(x: Int): Int {
    if (x == 0) return 0

    var num = x
    var result = 0

    while (num != 0) {
        val digit = num % 10
        num /= 10

        if (digit > 0 && result > (Int.MAX_VALUE - digit) / 10) return 0
        if (digit < 0 && result < (Int.MIN_VALUE - digit) / 10) return 0

        result = result * 10 + digit
    }

    return result
}
