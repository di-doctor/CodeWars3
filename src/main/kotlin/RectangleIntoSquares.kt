fun main() {
    val timeStart = System.nanoTime()
println(sqInRect(20,199))
    println((System.nanoTime()-timeStart)/1000)
}

fun sqInRect(lng: Int, wdth: Int): List<Int>? {
    if (lng == wdth) return null
    val listResult = mutableListOf<Int>()
    var length = lng
    var width = wdth
    while (length > 0 && width > 0) {
        if (length > width){
            length -= width
            listResult.add(width)
        }else{
            width-=length
            listResult.add(length)
        }
    }
    return listResult
}