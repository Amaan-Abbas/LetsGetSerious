package multiDiamentionalArray

class MatrixZero {

    // the space complexity can be reduced to O(1) and time complexity to O(mn)
    // current time complexity is O(mn + z(m+n))
    // current space complexity is O(z)

    fun setZeroes(matrix: Array<IntArray>) {
        val map = HashMap<Int, IntArray>()
        val m = matrix.size
        val n = matrix[0].size
        var key = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    map[++key] = intArrayOf(i, j)
                }
            }
        }

        for (arr in map.values) {
            val i = arr[0]
            val j = arr[1]

            for (k in 0 until m) {
                matrix[k][j] = 0
            }

            for (k in 0 until n) {
                matrix[i][k] = 0
            }
        }
    }
}