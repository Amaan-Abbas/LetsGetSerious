package recursion

fun reverse(arr: IntArray, start: Int, end: Int) {
    val start = start
    val end = end

    if (start > end) return

    val temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp

    reverse(arr, start + 1, end - 1)
}

fun main() {
    val ar = intArrayOf(1, 2, 3, 4, 5)
    println(ar.contentToString())

    reverse(ar, 0, ar.size - 1)
    println(ar.contentToString())
}