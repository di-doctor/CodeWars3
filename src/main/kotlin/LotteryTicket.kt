fun main() {

    val r = arrayOf("ABC" to 65, "HGR" to 74, "BYHT" to 74)
    println(bingo(r, 1))

}
//[ 'HGR', 74 ]

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String {
    return ticket.map { pair -> pair.first.any { it.code == pair.second } }
        .count { it }
        .let { if (it >= win) "Winner!" else "Loser!" }


}

fun bingo2(ticket: Array<Pair<String, Int>>, win: Int) =
    if (win <= ticket.count { pair -> pair.first.any { it.code == pair.second } }) "Winner!" else "Loser!"
