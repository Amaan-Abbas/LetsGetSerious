package arrays

//fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
//
//}

fun possibleCombinations(nums: IntArray): Int {
    var possibleValues = 1
    for (i in 1..nums.size) {
        possibleValues *= i
    }

    return possibleValues
}

fun main() {
}