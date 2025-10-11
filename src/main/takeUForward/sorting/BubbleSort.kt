package sorting

fun bubbleSort(arr: IntArray) {
    for (i in 0 until arr.size) {
        for (j in 0 until arr.size - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun display(arr: IntArray) {
    println("The elements are: ")
    for (i in arr) {
        print("$i ")
    }
}

fun main() {
    val arr = intArrayOf(2, 1 , 5, 6)

    //one way to display elements in string using the function .joinToString()
//    println(arr.joinToString(separator = " , ",
//        prefix = "[",
//        postfix = "]"))

    display(arr)
    println()

    bubbleSort(arr)

//    println("After sorting: ${arr.joinToString(separator = " , ",
//        prefix = "[",
//        postfix = "]")}")

    display(arr)
}