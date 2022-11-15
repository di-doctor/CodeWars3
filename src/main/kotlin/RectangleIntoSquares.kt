fun main() {


 }

fun User.Companion.foo(): Int{
    return 4
}


class User private constructor(val name:String){

     companion object     {
        val id: Int = 0
        fun getNameByEmail(eMail:String): User{

            return User(eMail.substringBefore("@"))
        }
        fun getNameDefault() = User("name default")

     }
}

fun timeStrToSeconds(str: String): Int {
    val reg: Regex = Regex("""(\d\d):(\d\d):(\d\d)""")
    reg.findAll(str)
        .map { matchResult ->matchResult.groupValues.drop(1)  }
        .flatten()
        .toList()
        .also { println(it) }
    return 0
}


fun longestRepetition(s: String): Pair<Char?, Int> {
    return Regex("""(.)\1*""").findAll(s)
        .map { it.value }
        .maxByOrNull { it.length }?.let { it[0] to it.length } ?: Pair(null, 0)
}

//abbbbb
fun longestRepetition2(s: String): Pair<Char?, Int> {
    if (s.isEmpty()) return Pair(null, 0)
    var currentChar: Char? = null
    var resultChar: Char? = null
    var count = 0
    var max = 0
    s.forEach {
        if (it == currentChar) count++
        else {
            currentChar = it
            count = 1
        }
        if (count > max) {
            max = count
            resultChar = currentChar
        }
    }
    return resultChar to max

}


private fun convert(value: Map.Entry<String, Int>): Boolean {
    return value.key.length > value.value
}

fun sqInRect(lng: Int, wdth: Int): List<Int>? {
    if (lng == wdth) return null
    val listResult = mutableListOf<Int>()
    var length = lng
    var width = wdth
    while (length > 0 && width > 0) {
        if (length > width) {
            length -= width
            listResult.add(width)
        } else {
            width -= length
            listResult.add(length)
        }
    }
    return listResult
}