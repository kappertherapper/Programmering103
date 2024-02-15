package Semesterprøve2015

import java.time.LocalTime
import java.time.temporal.ChronoUnit

open class Parkeringsplads(
    var nummer: Int,
    var parkeringshus: Parkeringshus,
) {
    var bil: Bil? = null
    var ankomst: LocalTime? = null

    fun addBil(bil: Bil) {
        this.bil = bil
        ankomst = LocalTime.now()
    }

    fun removeBil(bil: Bil) {
        this.bil = null
        ankomst = null
    }

    //S4
    open fun parkeringsPris(slutTid: LocalTime): Int {
        val ankomst = this.ankomst
        var pris = 0
        val tid = ankomst!!.until(slutTid, ChronoUnit.MINUTES).toInt()
        if (tid % 10 == 0) pris = tid / 10 * 6 else (tid / 10 + 1) / 6
        return pris
    }
}