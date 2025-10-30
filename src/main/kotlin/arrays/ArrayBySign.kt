package arrays

class ArrayBySign {

    // Using auxiliary space which makes the space complexity as O(n)
//    fun rearrangeArray(nums: IntArray): IntArray {
//        val n = nums.size
//        val posArr =IntArray(n/2)
//        val negArr = IntArray(n/2)
//        val ans = IntArray(n)
//
//        var j = 0
//        var k = 0
//
//        for (i in 0 until n) {
//            if (nums[i] >= 0) posArr[j++] = nums[i] else negArr[k++] = nums[i]
//        }
//
//        j = 0
//        k = 0
//
//        for (i in 0 until n) {
//            if (i%2 == 0) ans[i] = posArr[j++] else ans[i] = negArr[k++]
//        }
//
//        return ans
//    }

    // Using to pointer, thus, not requiring extra arrays to store the elements
    fun rearrangeArray(nums: IntArray): IntArray {
        val n = nums.size

        var posArr = 0
        var negArr = 1
        val ans = IntArray(n)

        for (i in 0 until n) {
            if (nums[i] > 0) {
                ans[posArr] = nums[i]
                posArr += 2
            } else {
                ans[negArr] = nums[i]
                negArr += 2
            }
        }

        return ans
    }
}

fun main() {
    val arr = intArrayOf(3,1,-2,-5,2,-4)
    val rearrange = ArrayBySign()
    print(rearrange.rearrangeArray(arr).contentToString())
}