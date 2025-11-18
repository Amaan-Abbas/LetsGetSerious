package recursion

fun recursion(n: Int) {
    if (n <= 9) {
        print(n)
        return
    }

    val d = n % 10

    recursion(n / 10)

    print(" " + d)
}

fun main() {
    val n = readln().toIntOrNull() ?: 0

    for(i in 1..n) {
        val num = readln().toIntOrNull() ?: 0
        recursion(num)
        println()

        val n: IntArray = intArrayOf()
    }
}