package Semesterprøve2015

import java.time.LocalTime

data class Parkeringsplads(
    val nummer: Int,
    val ankomst: LocalTime? = null,
    val invalideplads: Boolean = false,
    val parkeringshus: Parkeringshus,
    val bil: Bil
) {

    //S4
    fun prisForParkering(slutTid: LocalTime): Int {
        var tid = (ankomst?.minute)?.minus(slutTid.minute)
        var omkostning = 0
        if (invalideplads) return 0
        else if (tid != null) omkostning = (tid + 9) / 10 * 6
        return omkostning
    }
}