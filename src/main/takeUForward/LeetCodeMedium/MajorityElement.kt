package LeetCodeMedium

class MajorityElement {
    // Boyer - Moore Majority vote algorithm

    // This algo only works when there is a guaranteed existance of a majority candidate
    // It fails when there is no guarantee that there will be a majority candidate present.
    // This error may be overlooked by passing a second check using the same method but
    // just checking that the returned candidate is in majority or not.

    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate = 0

        for (i in nums) {
            if (count == 0) candidate = i
            count += if (candidate == i) 1 else -1
        }

        return candidate
    }
}