import java.util.*

object PlayPass {

    private fun playPass2(s: String, n: Int): String {
        return s.map {
            when {
                it.isLetter() -> shift(it, n)
                it.isDigit() -> (105 - it.code).toChar()
                else -> it
            }
        }.reversed().joinToString("")
    }

    private fun shift(c: Char, n: Int): Char {
        return when {
            c.isLowerCase() -> ((c.code - 97 + n) % 26 + 97).toChar()
            c.isUpperCase() -> ((c.code - 65 + n) % 26 + 65).toChar()
            else -> 'a'
        }
    }


    private fun playPass(s: String, n: Int): String {
        return s.lowercase(Locale.getDefault())
            .shiftEachLetter(n)
            .map { if (it.isDigit()) (105 - it.code).toChar() else it }
            .mapIndexed() { index, char -> if (index % 2 == 0 && char.isLetter()) char.uppercaseChar() else char }
            .reversed()
            .joinToString("")
    }

    private fun String.shiftEachLetter(n: Int): List<Char> {
        return this.map { c: Char -> if (c !in 'a'..'z') c else ((c.code - 97 + n) % 26 + 97).toChar() }
    }
}

fun main() {
    val list = listOf(1, 3, 10, 40, 5, 9, 1000)
    println(list.filter(::isDivideByTen))

}

private fun isDivideByTen(value: Int): Boolean {
    return value % 2 == 0
}

