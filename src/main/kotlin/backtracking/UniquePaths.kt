package backtracking

fun printPaths(r: Int, c: Int, m: Int, n: Int, str: String) {
    if (r > m || c > n) return

    if (r == m && c == n) {
        println(str)
    }

    printPaths(r + 1, c, m, n, str + "D")
    printPaths(r, c + 1, m, n, str + "R")
}

fun allDirections(r: Int, c: Int, m: Int, n: Int, str: String, visited: Array<BooleanArray>) {
    if (r < 0 || c < 0 || r > m || c > n || visited[r][c]) return
    if (r == m && c == n) {
        println(str)
        return
    }

    visited[r][c] = true

    allDirections(r + 1, c, m, n, str + "D",visited)
    allDirections(r, c - 1, m, n, str + "L",visited)
    allDirections(r, c + 1, m, n, str + "R",visited)
    allDirections(r - 1, c, m, n, str + "U",visited)

    visited[r][c] = false
}

fun main() {
//    printPaths(0, 0, 3, 2, "")
    val m = 3
    val n = 2
    val array = Array(m + 1) { BooleanArray(n + 1) }
    allDirections(0, 0, m, n, "", array)
}