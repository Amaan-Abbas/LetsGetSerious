package string

fun myAtoi(s: String): Int {
    var str = s.trim()
    if (str.isEmpty()) return 0

    var pointer = 0
    var sign = 1

    if (str[0] == '-') {
        sign = -1
        pointer++
    } else if (str[0] == '+') pointer++

    var output = 0
    val intMin = Int.MIN_VALUE/10
    val intMax = Int.MAX_VALUE/10

    while (pointer < str.length && str[pointer].isDigit()) {
        val digit = str[pointer].digitToInt()

        if (output > intMax || output == intMax && digit > 7) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        output = output * 10 + digit
        pointer++
    }

    return sign * output
}