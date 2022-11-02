class ReverseOrRotate {

    private fun String.isEven(): Boolean  =   map { it.toString().toInt() }.sum() % 2 == 0

    private fun String.shift(): String = substring(1, length) + this[0]

    fun revRot(nums: String, sz: Int): String {
        return nums.chunked(sz)
            .filter { it.length == sz }
            .joinToString(separator = "") { if (it.isEven()) it.reversed() else it.shift() }
    }
}


fun main() {
    val str = "123456987654"
    println(ReverseOrRotate().revRot("123412341234", 4))
}