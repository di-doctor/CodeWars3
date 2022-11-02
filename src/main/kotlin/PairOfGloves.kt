fun main() {
    val arr = "Hello my dear friend"
    arr.split(" ")
        .map { it.length }
        .let { it.sum()/it.size }.also { println(it) }
}

fun Char.convert(): Int{
    return code
}

fun numberOfPairs(gloves: List<String>): Int {
    return gloves.groupBy { it }
        .map { it.value.size / 2 }
        .sum()
}

fun numberOfPairs2(gloves: List<String>) = gloves.groupBy { it }.values.sumOf { it.size / 2 }

fun numberOfPairs3(gloves: List<String>): Int {
    return gloves.distinct().fold(0) { acc, s -> acc + gloves.count { it == s } / 2 }
}

