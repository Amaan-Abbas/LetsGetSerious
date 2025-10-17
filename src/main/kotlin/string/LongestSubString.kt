package string

class LongestSubString {
    /**
     * basic approach with the time complexity of O(n^2)
     fun lengthOfLongestSubstring(s: String): Int {
        var ans = 0

        for (i in 0 until s.length) {
            var sub = "" + s[i]
            for (j in i + 1 until s.length) {
                if (s[j] !in sub) {
                    sub += s[j]
                } else {
                    break
                }
            }

            ans = maxOf(ans, sub.length)
        }

        return ans
    }
    */

    // Time complexity of O(n)
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var ans = 0
        val seen = mutableSetOf<Char>()

        for (right in s.indices) {
            while (s[right] in seen) {
                seen.remove(s[left])
                left++
            }

            seen.add(s[right])
            ans = maxOf(ans, right - left + 1)
        }

        return ans
    }
}