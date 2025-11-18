package recursion

import java.util.Scanner

fun reverse(n: IntArray, idx: Int) {
    if (idx == 0) {
        print(n[idx])
        return
    }

    if (idx % 2 == 0) {
        print(n[idx])
        print(" ")
    }
    reverse(n, idx - 1)
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val arr = MutableList<Int>(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    reverse(arr.toIntArray(), arr.size - 1)
}