package takeUforward

fun selectionSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        var smallest = i

        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[smallest]) {
                smallest = j
            }
        }

        val temp = arr[i]
        arr[i] = arr[smallest]
        arr[smallest] = temp
    }
}

fun main() {
    val arr = intArrayOf(1, 3, 2, 5, 1)
    display(arr)

    selectionSort(arr)
    display(arr)
}

