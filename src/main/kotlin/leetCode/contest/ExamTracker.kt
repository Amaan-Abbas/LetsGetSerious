package leetCode.contest

class ExamTracker(
    val mpp: LinkedHashMap<Int, Int> = LinkedHashMap()
) {
    fun record(time: Int, score: Int) {
        mpp[time] = score
    }

    fun totalScore(startTime: Int, endTime: Int): Long {
        var sum: Long = 0

        for ((key, value) in mpp) {
            if (key in startTime..endTime) {
                sum += value
            }
        }
        return sum
    }
}