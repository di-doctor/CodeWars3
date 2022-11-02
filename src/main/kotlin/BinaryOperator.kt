import java.util.function.BiFunction
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator
import java.util.function.LongBinaryOperator
import kotlin.math.max
import kotlin.math.min

fun main() {

    val str ="hello"
    str.drop(1).dropLast(1).also { println(it) }

}

interface BinaryInt {
    fun execute(a: Int, b: Int): Int
}

private fun maxInt(a: Int, b: Int): Int {
    return max(a, b)
}

private fun minInt(a: Int, b: Int) = min(a, b)


fun foo(foo: IntBinaryOperator, first: Int, second: Int): Int {
    return foo.applyAsInt(first, second)
}
