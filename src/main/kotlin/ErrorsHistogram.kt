fun main() {
    println("hello".repeat(5))
    val str = """u  3     ***\rw  4     ****\rx  6     ******\rz  6     ******"""
    val s = "tpwaemuqxdmwqbqrjbeosjnejqorxdozsxnrgpgqkeihqwybzyymqeazfkyiucesxwutgszbenzvgxibxrlvmzihcb"
    val s2 =
        "rpwsjkxtjrgjqtrefihlfqsonsicunclherckvtcxbogxavbdbbpvbbllezxjgegilnbnnutqjtpmksdqxsrpmiwyzztnzxrupyxqppstttvwxrqwtxzstssuprrxsqrvtwpsurwxsuvqztuupyytzupqqwyrtppsqpxsrzpruwstvrrqyrsvqpzuvut\n" +
                "\n" +
                "bnwuqxnnvdydoooaixuawaahclmigykubcsoudqopmvajxbyrkxfakajypckfqisoywhmxwvoktemphjszrrqqpxytqtuypqttxwrqoqqusvsuuvywpvqwtwvwzuwvzssqwqzrquzuyswwvtzzzvvyzusvpvpvtw\n" +
                "\n" +
                "zvxyxwucfjvxtndnoqowrwwlpnkwjprirtrsbzjgseqradgbrdztbtvrtkxxzefymdjszyxgkodatqymfzwlxuxbpxxwsqsqrptvttsxzuwxuwprqtspvuwyvvvyptwrtptvwypyoqwypzwswrsqssputzzsyzvptwpqvtrzwpstvswyxz\n" +
                "\n" +
                "ozdhehtfolguqkpdficmfozudzbddpxanhfvahqgliwzawwebygrraoqacttjsmnygsazttidktxvrrzvzuvupwwpwxvrpzrvpypvssqsurzytzrpuywwppvtvquyqztqyzsypvqtyvrtuuuqpyz"

    val er: ErrorHistogram = ErrorHistogram()
    println(er.hist(s2))
    println(str)
    println(er.hist(s) == str)
}

class ErrorHistogram {

    fun hist(s: String): String {
        return s.groupBy { it }
            .mapValues { entry -> entry.value.size }
            .filterKeys { c: Char -> c in "uwxz" }
            .toList()
            .sortedBy { pair -> pair.first }
            .joinToString("""\r""") { pair -> generateString(pair) }
    }

    fun generateString(pair: Pair<Char, Int>): String {
        val s = "*".repeat(pair.second)
        return "${pair.first}  ${pair.second}     $s"
    }
}

