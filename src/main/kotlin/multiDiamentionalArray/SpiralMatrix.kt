package multiDiamentionalArray

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = mutableListOf<Int>()

        var left = 0
        var right = matrix[0].size
        var top = 0
        var bottom = matrix.size

        while (left < right && top < bottom) {
            for (i in left until right) {
                ans.add(matrix[top][i])
            }
            top += 1

            for (i in top until bottom) {
                ans.add(matrix[i][right - 1])
            }
            right -= 1

            if (!(left < right && top < bottom)) break

            for (i in right - 1 downTo left) {
                ans.add(matrix[bottom - 1][i])
            }
            bottom -= 1

            for (i in bottom - 1 downTo top) {
                ans.add(matrix[i][left])
            }
            left += 1
        }

        return ans
    }
}