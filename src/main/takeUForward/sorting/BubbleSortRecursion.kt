package sorting

fun bubbleRecursion(nums: IntArray, n: Int) {
    if (n == 1) return

    for (i in 0 until n - 1) {
        if (nums[i] > nums[i + 1]) {
            val temp = nums[i]
            nums[i] = nums[i + 1]
            nums[i + 1] = temp
        }
    }

    bubbleRecursion(nums, n - 1)
}

fun main() {
    val arr = intArrayOf(2, 3, 4, 1, 2)
    bubbleRecursion(arr, arr.size)

    display(arr)
}