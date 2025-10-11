package sorting

fun recursiveInsertion(nums: IntArray, i: Int, n: Int) {
    if (i == n) return

    var j = i
    while (j > 0 && nums[j - 1] >= nums[j]) {
        val temp = nums[j - 1]
        nums[j - 1] = nums[j]
        nums[j] = temp

        j--
    }

    recursiveInsertion(nums, i + 1, n)
}

fun main() {
    val arr = intArrayOf(2, 1, 5, 4, 1)
    recursiveInsertion(arr, 1, arr.size)

    display(arr)
}