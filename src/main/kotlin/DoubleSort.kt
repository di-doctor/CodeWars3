fun main() {
    val arr = arrayOf<Any>("Banana", "Orange", "Apple", "Mango", 0, 2, 2)
    println(DoubleSort.dbSort(arr).joinToString(" "))


}

object DoubleSort {
    fun dbSort(a: Array<Any>): Array<Any> {
        val pair: Pair<List<Any>, List<Any>> = a.partition { any: Any -> any is Int }
        val x = (pair.first as List<Int>).sorted()
        val y = (pair.second as List<String>).sorted()
        val resultList = x + y
        return Array(resultList.size) { i: Int -> resultList[i] }
    }

    fun dbSort2(a: Array<Any>): Array<Any> {
        val result = a.filterIsInstance<Int>().sorted() + a.filterIsInstance<String>().sorted()
        return result.toTypedArray()
    }

    fun dbSort3(a: Array<Any>): Array<Any> {
        return a.partition { it !is String }.let { (a, b) ->
            (a as List<Int>).sorted() + (b as List<String>).sorted()
        }.toTypedArray()
    }
}