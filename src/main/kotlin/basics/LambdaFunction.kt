package basics

fun main() {
    val words = readln()

    val vowelsOnly = words.filter { it in "AEIOUaeiou" }

//    println(vowelsOnly.joinToString("", "\"", "\""))

    println(vowelsOnly)

    val number = intArrayOf(1, 2, 3, 4, 5)
    println(number.contentToString())

    val evenCheck = number.filter { it % 2 == 0 }

//    println(evenCheck.contentToString())

    println(evenCheck)
}