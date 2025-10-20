package arrays

class ValueAfterOperation {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0

        for (i in operations) {
            x = when(i) {
                "X++", "++X" -> x + 1
                "X--", "--X" -> x - 1
                else -> x
            }
        }

        return x
    }
}