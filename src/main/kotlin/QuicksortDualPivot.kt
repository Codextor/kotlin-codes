/**
 * Swap two elements in an array.
 */
private fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

/**
 * Partition the array around two pivots.
 * Return the indices of the pivots.
 */
private fun partition(arr: Array<Int>, left: Int, right: Int): Pair<Int, Int> {
    if (arr[left] > arr[right]) swap(arr, left, right)
    val leftPivot = arr[left]
    val rightPivot = arr[right]

    var leftPivotIndex = left
    var rightPivotIndex = right

    for (index in leftPivotIndex+1 until rightPivotIndex) {
        if (arr[index] < leftPivot) {
            leftPivotIndex++
            swap(arr, leftPivotIndex, index)
        } else if (arr[index] >= rightPivot) {
            while (arr[rightPivotIndex-1] > rightPivot && index < rightPivotIndex-1) rightPivotIndex--

            rightPivotIndex--
            swap(arr, rightPivotIndex, index)

            if (arr[index] < leftPivot) {
                leftPivotIndex++
                swap(arr, leftPivotIndex, index)
            }
        }
    }

    swap(arr, left, leftPivotIndex)
    swap(arr, right, rightPivotIndex)

    return Pair(leftPivotIndex, rightPivotIndex)
}

/**
 * Quick sort the array using two pivots.
 */
private fun quickSortDualPivot(arr: Array<Int>, left: Int, right: Int) {
    if (left < right) {
        val pivotIndices = partition(arr, left, right)
        quickSortDualPivot(arr, left, pivotIndices.first - 1)
        quickSortDualPivot(arr, pivotIndices.first + 1, pivotIndices.second - 1)
        quickSortDualPivot(arr, pivotIndices.second + 1, right)
    }
}

fun main() {

    val arrayOfIntegers = readLine()?.trimEnd()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return

    quickSortDualPivot(arrayOfIntegers, 0, arrayOfIntegers.size-1)

    arrayOfIntegers.forEach { print("$it ") }
}
