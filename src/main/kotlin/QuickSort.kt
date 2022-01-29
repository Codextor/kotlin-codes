/**
 * Swap two elements in an array.
 */
private fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

/**
 * Partition the array around a randomly selected pivot.
 * Return the index of the pivot.
 */
private fun partition(arr: Array<Int>, left: Int, right: Int): Int {
    val randomIndex = (left..right).random()
    swap(arr, randomIndex, right)
    val pivot = arr[right]

    var pivotIndex = left - 1
    for (index in left..right) {
        if (arr[index] <= pivot) {
            pivotIndex++
            swap(arr, pivotIndex, index)
        }
    }
    return pivotIndex
}

/**
 * Quick sort the array.
 */
private fun quickSort(arr: Array<Int>, left: Int, right: Int) {
    if (left < right) {
        val pivotIndex = partition(arr, left, right)
        quickSort(arr, left, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, right)
    }
}

fun main() {

    val arrayOfIntegers = readLine()?.trimEnd()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return

    quickSort(arrayOfIntegers, 0, arrayOfIntegers.size-1)

    arrayOfIntegers.forEach { print("$it ") }
}
