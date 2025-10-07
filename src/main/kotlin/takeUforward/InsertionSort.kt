package takeUforward

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        var j = i

        while (j > 0 && arr[j - 1] > arr[j]) {
            val temp = arr[j - 1]
            arr[j - 1] = arr[j]
            arr[j] = temp

            j--
        }
    }
}

fun main() {
    val arr = intArrayOf(2, 4, 1, 3, 7)
    display(arr)
    println()

    insertionSort(arr)
    display(arr)
}