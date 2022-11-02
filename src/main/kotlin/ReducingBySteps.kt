import java.util.function.LongBinaryOperator
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val array = longArrayOf(18, 69, -90, -78, 65, 40)
    println(operArray(::mini, array, array[0]).joinToString(" "))
}

fun gcdi(x1: Long, y1: Long): Long {
    var xx = x1
    var yy = y1
    while (xx != yy) {
        if (xx > yy) {
            xx -= yy;
        } else {
            yy -= xx;
        }
    }
    return xx;
}

fun lcmu(a: Long, b: Long): Long {
    return abs(a * b) / gcdi(a, b)
}

fun som(a: Long, b: Long): Long {
    return a + b
}

fun maxi(a: Long, b: Long): Long {
    return max(a, b)
}

fun mini(a: Long, b: Long): Long {
    return min(a, b)
}

fun operArray(operator: LongBinaryOperator, arr: LongArray, init: Long): LongArray {
    val result = LongArray(arr.size)

    result[0] = operator.applyAsLong(init, arr[0])
    for (i in 1 until arr.size) {
        result[i] = operator.applyAsLong(result[i - 1], arr[i])
    }

    return result
}