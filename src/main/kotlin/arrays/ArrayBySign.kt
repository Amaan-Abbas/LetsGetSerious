package arrays

class ArrayBySign {
    fun rearrangeArray(nums: IntArray): IntArray {
        val n = nums.size
        val posArr =IntArray(n/2)
        val negArr = IntArray(n/2)
        val ans = IntArray(n)

        var j = 0
        var k = 0

        for (i in 0 until n) {
            if (nums[i] >= 0) posArr[j++] = nums[i] else negArr[k++] = nums[i]
        }

        j = 0
        k = 0

        for (i in 0 until n) {
            if (i%2 == 0) ans[i] = posArr[j++] else ans[i] = negArr[k++]
        }

        return ans
    }
}