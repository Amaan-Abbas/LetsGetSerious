package arrays

class MedianOfArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n1 = nums1.size
        val n2 = nums2.size
        val n = n1 + n2

        var pointer1 = 0
        var pointer2 = 0
        var i = 0

        val sortedArray = IntArray(n)

        while (i != n) {
            if (pointer1 == n1 || pointer2 == n2) break

            if (nums1[pointer1] > nums2[pointer2]) {
                sortedArray[i] = nums2[pointer2]
                pointer2++
            } else {
                sortedArray[i] = nums1[pointer1]
                pointer1++
            }

            i++
        }

        while (pointer1 != n1) {
            sortedArray[i] = nums1[pointer1]
            pointer1++
            i++
        }

        while (pointer2 != n2) {
            sortedArray[i] = nums2[pointer2]
            pointer2++
            i++
        }

        val ans = if (n%2 == 0) {
            (sortedArray[n/2] + sortedArray[n/2 - 1])/2.0
        } else {
            sortedArray[n/2].toDouble()
        }

        return ans
    }
}