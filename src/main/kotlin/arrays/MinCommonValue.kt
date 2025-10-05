package arrays

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    val set = nums1.toHashSet()

    for(i in set) {
        if (i in nums2) return i
    }

    return -1
}