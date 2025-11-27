package arrays

class UnionSorted {
    fun unionArray(num1: IntArray, num2: IntArray): IntArray {
        val n = num1.size
        val m = num2.size
        val newArray = intArrayOf()

        var i = 0
        var j = 0
        var pointer = 0
        var prev = Int.MIN_VALUE

        while (i < n && j < m) {
            if (num1[i] <= num2[j]) {
                if (num1[i] == prev) {
                    i++
                    continue
                }
                prev = num1[i++]
                newArray[pointer++] = prev
            } else {
                if (num1[j] == prev) {
                    j++
                    continue
                }
                prev = num1[j++]
                newArray[pointer++] = prev
            }
        }

        return newArray
    }
}

fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    val arr2 = intArrayOf(1, 2, 7)
    val union  = UnionSorted()

    val arr = union.unionArray(arr1, arr2)

    println(arr.contentToString())
}