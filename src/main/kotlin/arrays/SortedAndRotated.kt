package arrays

class SortedAndRotated {
    fun check(nums: IntArray): Boolean {
        var count = 0
        val n = nums.size

        for (i in 1 until n) {
            if (nums[i] < nums[i - 1]) count++
            if (count > 1) return false
        }

        return count == 0 || nums.last() <= nums.first()
    }
}