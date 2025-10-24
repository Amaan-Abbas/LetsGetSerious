package arrays

class SIngleNumber {
    fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()

        for (i in nums) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        return map.entries.find {it.value == 1}!!.key
    }
}