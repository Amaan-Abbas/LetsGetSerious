package functions

// Basic
private val lambda: (Int, Int) -> Int = { a, b -> a + b }
private val upperCase: (String) -> String = { it.uppercase() }
private val isEven: (Int) -> Boolean = { a -> a % 2 == 0 }
private val mutp: (Int) -> Int = { a -> a * 3 }
private val square: (Int) -> Int = { it * it }
private val greeting: () -> Unit = { println("Hello world!") }

// Intermediate
private val allOdd: (List<Int>) -> List<Int> = { list ->
//    val list = mutableListOf<Int>()
//    for (i in it) {
//        if (i % 2 != 0) list.add(i)
//    }
//
//    list

    list.filter { it % 2 != 0}
}
private val startWithA: (List<String>) -> List<String> = { word ->
    word.filter { it[0] == 'A' }
}


fun main() {
    println(lambda(3, 5))
    println(upperCase("Amaan"))
    println(isEven(100))
    println(isEven(3))
    println(mutp(89) * 7)
    println(square(5))
    greeting()

    println(allOdd(listOf(2, 5, 6, 1, 4, 3)))

    val words = listOf("Syed", "Amaan", "Abbas", "Naqvi")
    val length = words.map { it.length }
    println(length)

    println(startWithA(words))
}