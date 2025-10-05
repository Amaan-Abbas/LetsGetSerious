package arrays

fun main() {

    val message = arrayOf("l","i","l","i","l")
    val bannedWords = arrayOf("d","a","i","v","a")

    val map = hashMapOf<String, Int>()
    for (i in message) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    val map2 = hashMapOf<String, Int>()
    for (i in bannedWords) {
        map2[i] = map.getOrDefault(i, 0) + 1
    }

    var count = 0
    for (i in map.keys) {
        if (i in map2.keys) count += map.getValue(i)
    }

    println(count >= 2)
}