/**
 * Swap two elements in an array.
 */
fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

/**
 * Partition the array around a randomly selected pivot.
 * Return the index of the pivot.
 */
fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivotIndex = (low..high).random()
    swap(arr, pivotIndex, high)
    val pivot = arr[high]

    var i = low - 1
    for (j in low..high) {
        if (arr[j] <= pivot) {
            i++
            swap(arr, i, j)
        }
    }
    return i
}

/**
 * Quick sort the array.
 */
fun quickSort(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun main() {

    val arrayOfIntegers = readLine()?.trimEnd()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return

    quickSort(arrayOfIntegers, 0, arrayOfIntegers.size-1)

    arrayOfIntegers.forEach { print("$it ") }
}
