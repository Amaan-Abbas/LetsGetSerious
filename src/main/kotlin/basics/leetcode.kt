package basics

import java.util.Stack
import kotlin.math.abs
import kotlin.math.sqrt

fun largestTriangleArea(points: Array<IntArray>): Double {
    val size = points.size * (points.size - 1) / 2
    val distance = getDistances(points, size)

    var maxDistance = Double.MIN_VALUE

    for (i in 0..< distance.size - 2) {
        for (j in i + 1..< distance.size - 1) {
            for (k in j + 1..< distance.size) {
                val a = distance[i]
                val b = distance[j]
                val c = distance[k]

                val s = ((a + b + c) / 2)
                val A = sqrt(s * (s - a) * (s - b) * (s - c))

                if (maxDistance < A) maxDistance = A
            }
        }
    }
    return maxDistance
}

fun getDistances(points: Array<IntArray>, size: Int): DoubleArray {
    val arr = mutableListOf<Double>()

    for (i in 0..< points.size - 1) {
        for (j in i + 1 ..< points.size) {
            val numerator = points[j][1] - points[i][1]
            val denominator = points[j][0] - points[i][0]
            if (denominator != 0 && numerator != 0) {
                val dist = abs(numerator / denominator)
                arr.add(dist.toDouble())
            }
        }
    }
    val newArr = arr.toDoubleArray()
    println(newArr.contentToString())
    return newArr
}

fun calculateArea(a: Int, b: Int, c: Int): Double {
    val s = (a + b + c)/2.0
    val area = sqrt(s * (s - a.toDouble()) * (s - b.toDouble()) * (s - c.toDouble()))
    return area
}

fun triangleNumber(nums: IntArray): Int {
    nums.sort()
    var count = 0

    for (i in nums.size - 1 until 2) {
        val check1 = nums[i] < nums[i - 1] + nums[i - 2]
        val check2 = nums[i - 1] < nums[i] + nums[i - 2]
        val check3 = nums[i - 2] < nums[i] + nums[i - 1]
        print(check1)
        print(check2)
        print(check3)

        if (check1 && check2 && check3) count++
    }

    return count
}

fun main() {
    val stack = charArrayOf()
    val str = "amaan"
    println(str.length)


        //189
    //82
    //1043

    val arr = IntArray(5)

}