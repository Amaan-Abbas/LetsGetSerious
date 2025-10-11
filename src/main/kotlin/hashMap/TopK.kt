package hashMap

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val mpp = HashMap<Int, Int>()
    val ans = mutableListOf<Int>()

    for (i in nums) {
        mpp[i] = mpp.getOrDefault(i, 0) + 1
    }

    for (i in mpp.keys) {
        // (mpp[i] >= k) gives an error that there might be a null value being compared so it tells
        //to use a null safety operator/method. otherwise use getOrDefault()
        if (mpp.getOrDefault(i, 0) >= k) {
            ans.add(i)
        }
    }

    return ans.toIntArray()
}

fun main() {
    val arr = intArrayOf(1,2,1,2,1,2,3,1,3,2)
    println(topKFrequent(arr, 2).contentToString())
}
