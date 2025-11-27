package backtracking


fun permutation(arr: IntArray, ans: MutableList<List<Int>>, temp: MutableList<Int>, visited: BooleanArray) {
    val n = arr.size

    if (temp.size == n) {
        val newArr = temp.toList()
        ans.add(newArr)
        return
    }

    for (i in 0 until n) {
        if (visited[i]) continue
        visited[i] = true
        temp.add(arr[i])
        permutation(arr, ans, temp, visited)
        visited[i] = false
        temp.removeLast()
    }
}

fun main() {
    val ans = mutableListOf<List<Int>>()
    val num = intArrayOf(1, 2, 3)
    val visited = BooleanArray(num.size)
    permutation(num, ans, mutableListOf(), visited)
    println(ans.joinToString(",", "[", "]"))
}

