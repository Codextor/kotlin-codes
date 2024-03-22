/**
 * Given a list of 24-hour clock time points in "HH:MM" format,
 * return the minimum minutes difference between any two time-points in the list.
 *
 *
 * Example 1:
 *
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 *
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= timePoints.length <= 2 * 10^4
 * timePoints[i] is in the format "HH:MM".
 * @see <a href="https://leetcode.com/problems/minimum-time-difference/">LeetCode</a>
 */
fun findMinDifference(timePoints: List<String>): Int {
    val minutesInAnHour = 60
    val minutesInADay = 1440
    if (timePoints.size > minutesInADay) return 0 // More than 1440 time points imply there must be duplicates

    val timePointsInMinutes = BooleanArray(minutesInADay)
    timePoints.forEach { timePoint ->
        val (hours, minutes) = timePoint.split(":")
        val totalMinutes = hours.toInt() * minutesInAnHour + minutes.toInt()
        if (timePointsInMinutes[totalMinutes]) return 0 // Duplicate time point found
        timePointsInMinutes[totalMinutes] = true
    }

    var firstTimeInMinutes = -1
    var previousTimeInMinutes = -1
    var minimumMinutesDifference = Int.MAX_VALUE

    for (minute in 0 until minutesInADay) {
        if (timePointsInMinutes[minute]) {
            if (firstTimeInMinutes == -1) {
                firstTimeInMinutes = minute
            } else {
                minimumMinutesDifference = minOf(minimumMinutesDifference, minute - previousTimeInMinutes)
            }
            previousTimeInMinutes = minute
        }
    }

    // Handle the circular nature of the clock
    minimumMinutesDifference =
        minOf(minimumMinutesDifference, firstTimeInMinutes + minutesInADay - previousTimeInMinutes)

    return minimumMinutesDifference
}
