import kotlin.math.*

fun main(vararg str: String) {

    println(interp({ cos(it) }, 0.0, 21.0, 7))
    println(interp2({ cos(it) }, 0.0, 21.0, 7))
    //[0.0; 0.3; 0.6]
    List(10){it}

}

fun reverseLetter(str: String): String {
    return str.filter(Char::isLetter)
        .reversed()
}

fun interp(func: (Double) -> Double, l: Double, u: Double, n: Int): List<Double> {
    val diff = (u - l) / n
    return (0 until n).map { floor(func(l + diff * it) * 100) / 100.0 }
}
fun interp2(func: (Double) -> Double, l: Double, u: Double, n: Int): List<Double> {
    val d = (u-l)/n
    return List(n){func.invoke(l+d*it)}
}


