package basics

class Hashing(arr: Array<Int>) {

    lateinit var hashArray: Array<Int>

    init {
        val elementNumbers = arr.maxOrNull() ?: 0
        hashArray = Array(elementNumbers + 1) { 0 }

        for (i in arr) {
            hashArray[i]++
        }
    }

    fun getFrequency(idx: Int): Int = if (idx < hashArray.size) hashArray[idx] else 0

//    val value: (Int) -> Int = { idx -> hashArray[idx] }
}

fun main() {
    val arr = arrayOf(1, 2, 1, 3, 2)

    val hash = Hashing(arr)
    println("Number of elements present in the array: ")

    for (i in arr.minOrNull()!!..arr.maxOrNull()!!) {
        println("$i : ${hash.getFrequency(i)}")
    }
}