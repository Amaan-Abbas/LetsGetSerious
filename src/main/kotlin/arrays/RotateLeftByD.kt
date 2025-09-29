package arrays

object RotateLeftByD {
    //lambda expression: using the lambda as a function.
    val remain: (Int, Int) -> Int = { size, rotate -> rotate % size }

    fun rotate(arr: Array<Int>): Array<Int> {
        val temp = arr[0]

        for (i in 1 until arr.size) {
            arr[i - 1] = arr[i]
        }

        arr[arr.size - 1] = temp

        return arr
    }
}

fun main() {
    var arr = arrayOf(1, 2, 3)
    val times = 5

    val remainTimes = RotateLeftByD.remain(arr.size, times)

    //_ is used to ignore parameters intentionally because there is no use of that parameter and the
    //compiler mentions that there is an unused parameter, so we use _ to tell the compiler to ignore
    //the unused parameter.
    (1..remainTimes).forEach { _ ->
        arr = RotateLeftByD.rotate(arr)
    }

    println(arr.contentToString())
}