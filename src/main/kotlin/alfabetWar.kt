fun main() {
    println(alphabetWar("wwwwww"))

    println("wetewyte".getPowerByIndex("wet"))
}

fun alphabetWar(fight: String): String {
    var scoreRight = 0
    var scoreleft = 0
    for (char in fight) {
        when (char) {
            'w' -> scoreleft += 4
            'p' -> scoreleft += 3
            'b' -> scoreleft += 2
            's' -> scoreleft += 1
            'm' -> scoreRight += 4
            'q' -> scoreRight += 3
            'd' -> scoreRight += 2
            'z' -> scoreRight += 1
        }
    }
    return when {
        scoreleft > scoreRight -> "Left side wins!"
        scoreleft < scoreRight -> "Right side wins!"
        else -> "Let's fight again!"
    }
}

fun alphabetWar2(fight: String): String {
    val map = mapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1, 'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val sum = fight.sumOf { char -> map.getOrDefault(char, 0) }
    return when {
        sum > 0 -> "Left side wins!"
        sum < 0 -> "Right side wins!"
        else -> "Let's fight again!"

    }
}
fun String.getPowerByIndex(values: String): Int {
    return this.sumBy { values.indexOf(it) + 1 }
}
//fun alphabetWar3(fight: String): String {
//    val right = "zdqm"
//    val left = "sbpm"
//    fight.
//}

