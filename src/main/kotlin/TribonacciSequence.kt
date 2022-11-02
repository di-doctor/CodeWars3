class TribonacciSequence {

    fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
        val tList = mutableListOf<Double>()
        tList.add(signature[0])
        tList.add(signature[1])
        tList.add(signature[2])
        var count = 3
        while (count < n) {
            tList.add(tList[count - 1] + tList[count - 2] + tList[count - 3])
            count++
        }
        return tList.toDoubleArray()
    }

    fun tribonacci2(signature: DoubleArray, n: Int): DoubleArray {
        val tArray = DoubleArray(n)
        tArray[0] = signature[0]
        tArray[1] = signature[1]
        tArray[2] = signature[2]
        (3 until n).map { tArray[it] = tArray[it - 1] + tArray[it - 2] + tArray[it - 3] }
        return tArray

    }

    fun tribonacci3(signature: DoubleArray, n: Int): DoubleArray {
        return generateSequence(Triple(signature[0], signature[1], signature[2])) {
            Triple(
                it.second,
                it.third,
                it.first + it.second + it.third
            )
        }
            .map { it.first }
            .take(n)
            .toList()
            .toDoubleArray()
    }
}

fun main() {

    generateSequence(1) { if (it < 8) it+2 else null }
        .joinToString()
        .also { println(it) }
}