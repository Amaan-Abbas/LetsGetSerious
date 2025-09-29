package basics

fun printName(i: Int, n: Int) {
    var inc = n
    if (inc == i) return
    println("Amaan")
    inc++

    printName(i, inc)
}

fun linearPrinting(i: Int, n: Int) {
    var inc = n
    println(inc)
    if (n == i) return
    inc++

    linearPrinting(i, inc)
}

fun reversePrinting(i: Int) {
    var inc = i
    if (inc < 1) return
    println(inc)
    reversePrinting(--inc)
}

fun backtrackingLinear(i: Int) {
    if (i < 1) return
    var change = i
    backtrackingLinear(--change)
    println(change + 1)
}

fun backtrackingReverse(i: Int) {
    if (i > 10) return
    backtrackingReverse(i + 1)
    println(i)
}

fun check(n: Int) {
    var copy = n
    if (n < 1) return
    check(--copy)
    println(copy + 1)
}

fun main() {
    printName (i = 5, n = 0)

    linearPrinting(10, 1)

    reversePrinting(10)

    backtrackingLinear(5)

    backtrackingReverse(1)

    check(5)
}