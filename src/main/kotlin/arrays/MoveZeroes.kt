package arrays

//fun moveZeroes(array: Array<Int>): Array<Int> {
//    for (i in 0..<array.size) {
//        if (array[i] == 0) {
//            for (j in i + 1..<array.size) {
//                if (array[j] != 0) {
//                    val temp = array[j]
//                    array[j] = array[i]
//                    array[i] = temp
//                    break
//                }
//            }
//        }
//    }
//
//    return array
//}

fun moveZeroes(array: IntArray) {
    var count = 0

    for (i in 0 until array.size) {

        if (array[i] != 0) {
            val temp = array[i]
            array[i] = array[count]
            array[count] = temp

            count++
        }
    }
}

fun main() {
    val array: IntArray = intArrayOf(1, 2, 0, 4, 3, 0, 5, 0)
    moveZeroes(array)

    println(array.contentToString())
}