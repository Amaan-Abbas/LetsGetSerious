package backtracking

fun pathDirections(r: Int, c: Int, m: Int, n: Int, str: String, visited: Array<BooleanArray>, arr: Array<IntArray>) {
    if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || arr[r][c] == 0) return

    if (r == m - 1 && c == n - 1) {
        println(str)
        return
    }

    visited[r][c] = true

    pathDirections(r + 1, c, m, n, str + "D", visited, arr)
    pathDirections(r, c - 1, m, n, str + "L", visited, arr)
    pathDirections(r, c + 1, m, n, str + "R", visited, arr)
    pathDirections(r - 1, c, m, n, str + "U", visited, arr)

    visited[r][c] = false
}

fun withoutVisited(r: Int, c: Int, m: Int, n: Int, str: String, arr: Array<IntArray>) {
    if (r < 0 || c < 0 || r >= m || c >= n || arr[r][c] == 0 || arr[r][c] == -1) return

    if (r == m - 1 && c == n - 1) {
        println(str)
        return
    }

    arr[r][c] = -1

    withoutVisited(r + 1, c, m, n, str + "D", arr)
    withoutVisited(r, c - 1, m, n, str + "L", arr)
    withoutVisited(r, c + 1, m, n, str + "R", arr)
    withoutVisited(r - 1, c, m, n, str + "U", arr)

    arr[r][c] = 1
}

fun main() {
    val m = 4
    val n = 4

    val arr = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1)
    )
    val visited = Array(m + 1) { BooleanArray(n + 1) }
    pathDirections(0, 0, m, n, "", visited, arr)
}