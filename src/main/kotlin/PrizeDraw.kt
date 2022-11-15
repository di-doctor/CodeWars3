import java.util.*
import kotlin.Comparator

fun main() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println(filteredMap) // {key11=11}

    println(Char.MAX_HIGH_SURROGATE)
    println(Char.MAX_SURROGATE)
    println(Char.MAX_VALUE)
    println(Char.SIZE_BITS)
    println(Char.SIZE_BYTES)
    println(Char.MIN_VALUE)
    println(Char.MIN_SURROGATE)
    println(Char.MIN_LOW_SURROGATE)


}

fun nthRank(st: String, we: IntArray, n: Int): String {
    val splitString = st.split(",")
    if (st.isEmpty()) return "No participants"
    if (n > splitString.size) return "Not enough participants"
    return splitString
        .zip(we.toList()).also { println(it) }
        .map { pair -> Pair(pair.first, pair.second * winnerNumber(pair.first)) }
        .sortedWith(kotlin.Comparator<Pair<String, Int>> { o1, o2 -> o2.second - o1.second })
        .get(n - 1)
        .first
}

fun winnerNumber(str: String): Int {
    return str.uppercase().sumOf { c: Char -> c.code - 64 } + str.length
}
