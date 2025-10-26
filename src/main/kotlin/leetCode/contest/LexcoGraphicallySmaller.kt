package leetCode.contest

import kotlin.text.iterator

class LexcoGraphicallySmaller {
    fun lexSmallest(S: String): String {

        var change = -1
        for (i in S) {
            change++
            if (i == 'a') continue
            else {
                val loc = find(S.substring(S.indexOf(i) + 1), i)
                change += loc + 1
            }
        }

        return ""
    }

    fun find(S: String, word: Char): Int {
        var index = -1
        var temp = word

        for (i in S) {
            if (temp > i) temp = i
            index++
        }

        return index
    }
}