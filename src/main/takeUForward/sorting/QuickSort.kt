package sorting


class QuickSort {

    fun quickSort(arr: IntArray, left: Int, right: Int) {
        if (left < right) {
            val pivotIdx = pivot(arr, left, right)

            quickSort(arr, left, pivotIdx - 1)
            quickSort(arr, pivotIdx + 1, right)
        }
    }

    fun pivot(nums: IntArray, low: Int, high: Int): Int {

        val pivot = low
        var i = low
        var j = high

        while (i < j) {
            while (nums[pivot] >= nums[i] && i <= high - 1) i++
            while (nums[pivot] < nums[j] && j >= low + 1) j--

            if (i < j) {
                swap(nums, i, j)
            }
        }

        swap(nums, pivot, j)

        return j
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}

fun main() {
    val obj = QuickSort()

    val arr = intArrayOf(2, 1, 1, 6, 7, 3, 1)
    obj.quickSort(arr, 0, arr.size - 1)

    display(arr)
}
