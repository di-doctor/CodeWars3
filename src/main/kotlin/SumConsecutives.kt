fun main() {
    val list = listOf(1, 4, 4, 4, 0, 4, 3, 3, 9, 9, 1)
    println(sumConsecutives(list))
    println(sumConsecutives2(list))
    println(sumConsecutives3(list))
    println(sumConsecutives4(list))
}

fun sumConsecutives(s: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>()
    var previousValue: Int? = null
    var sum = 0
    for ((index, current) in s.withIndex()) {
        if (current == previousValue) {
            sum += current
        } else {
            resultList.add(sum)
            sum = current
        }
        previousValue = current
        if (index == s.lastIndex) resultList.add(sum)
    }
    resultList.removeAt(0)
    return resultList
}

fun sumConsecutives2(s: List<Int>): List<Int> {
    return mutableListOf<Int>(s[0]).also { mList ->
        (1..s.lastIndex).forEach {
            if (s[it] == s[it - 1]) mList[mList.lastIndex] += s[it] else mList.add(s[it])
        }
    }
}

fun sumConsecutives3(s: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>()
    var prevValue: Int? = null
    s.forEach {
        if (it == prevValue) resultList[resultList.lastIndex] += it
        else resultList.add(it)
        prevValue = it
    }
    return resultList
}

fun sumConsecutives4(s: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>(s[0])
    (1..s.lastIndex).forEach {
        if (s[it] == s[it - 1]) resultList[resultList.lastIndex] += s[it] else resultList.add(s[it])
    }
    return resultList
}

