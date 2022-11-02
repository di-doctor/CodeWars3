import kotlin.random.Random

fun main() {


    val list = listOf<String>("Камень", "Ножницы", "Бумага")
    val arr = Array(1000) { choice(list) }.toList()
   arr.groupBy { it }.map { "${it.key} - ${it.value.size}" }
       .forEach { println(it) }
}

fun choice(list: List<String>): String {
    val size = list.size
    return list[Random.nextInt(size)]

}


data class Human(var capacity: Int = 0)

fun sumParts(ls: IntArray): IntArray {
    var sum: Int = 0
    val resultArray = IntArray(ls.size + 1)
    resultArray[ls.size] = 0

    for (i in ls.size - 1 downTo 0) {
        sum += ls[i]
        resultArray[i] = sum
    }
    return resultArray
}

fun sumParts2(ls: IntArray): IntArray {
    val arrInt = IntArray(ls.size + 1)
    for (index in ls.indices.reversed()) {
        arrInt[index] = arrInt[index + 1] + ls[index]
    }
    return arrInt
}

fun sumParts3(ls: IntArray): IntArray {
    return ls.foldRightIndexed(IntArray(ls.size + 1)) { index: Int, i: Int, acc: IntArray ->
        acc[index] = acc[index + 1] + i; acc
    }

}

fun sum(ls: IntArray): IntArray {
    return ls.foldRightIndexed(IntArray(ls.size + 1)) { index: Int, i: Int, acc: IntArray ->
        acc[index] = acc[index + 1] + i; acc
    }
}

