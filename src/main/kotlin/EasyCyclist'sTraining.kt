import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.roundToInt
import kotlin.math.sin

fun main() {
    println(temps(30.0, 5.0, 30.0))
    println(temps(30.0, 50.0, 30.0))
    println(temps(30.0, 8.0, 20.0))
}

const val WATTS0 = 225
const val GRAVITY_ACC = 9.81
const val MASS = 80
const val DRAG = 60.0 * 0.3 / 3.6
const val G_THRUST = 60 * 3.6 * 3.6
const val D_WATTS = 0.5
const val DELTA_T = 60.0

fun temps(v0: Double, slope: Double, dTot: Double): Int {
    var distance = v0 * DELTA_T / 3.6
    var velocityCurrent = v0 / 3.6
    var wattsCurrent: Double = WATTS0.toDouble()
    var totalTime = DELTA_T
    while (distance < dTot * 1000) {
        wattsCurrent = watts(wattsCurrent)
        velocityCurrent += acceleration(velocityCurrent, slope, wattsCurrent) * DELTA_T
        distance += velocityCurrent * DELTA_T
        totalTime += DELTA_T
        if (velocityCurrent * 3.6 - 3.0 < 0.01) return -1
    }
    return (totalTime / 60).roundToInt()
}

fun acceleration(velocity: Double, slope: Double, watts: Double): Double {
    val alfa = atan(slope / 100)

    val forceOfPedaling = G_THRUST * watts / (velocity * MASS * 3.6)
    val gravityAcc = MASS * GRAVITY_ACC * sin(alfa)
    val airDrag = DRAG * velocity * velocity * 3.6 * 3.6 / MASS

    val result = (forceOfPedaling - gravityAcc - airDrag) / MASS
    return if (abs(result) < 0.00001) 0.0
    else result
}

fun watts(watt: Double): Double {
    val result = watt - D_WATTS * DELTA_T
    return if (result < 0) 0.0 else result
}
