package Semesterprøve2015

import java.time.LocalTime

class Invalideplads (
    nummer: Int,
    parkeringshus: Parkeringshus,
    val areal: Double, ): Parkeringsplads(nummer, parkeringshus) {
        override fun parkeringsPris(slutTid: LocalTime): Int {
            return 0
        }

}