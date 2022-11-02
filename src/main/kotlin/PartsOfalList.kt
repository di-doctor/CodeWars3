import java.util.Arrays

fun main() {
    val arr = arrayOf("az", "toto", "picaro", "zone", "kiwi")
    partlist(arr).forEach { println(it.joinToString()) }

}


fun partlist(arr:Array<String>):Array<Array<String>> {
    val l = arr.toList()
    val list1 = (1 until arr.size).map { l.subList(0, it) }
        .map { it.joinToString(" ") }
    val list2 = (1 until arr.size).map { l.subList(it, arr.size) }
        .map { it.joinToString (" ") }
    return list1.zip(list2){a: String, b: String -> arrayOf(a,b)  }.toTypedArray()
}

fun partlist2(arr:Array<String>):Array<Array<String>> {
    return (0..arr.size)
        .map { arrayOf(arr.take(1).joinToString(" "),arr.drop(1).joinToString(" ")) }
        .toTypedArray()
}