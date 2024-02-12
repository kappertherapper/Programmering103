package Semesterprøve2015

import java.time.LocalTime

data class Invalideplads (
    val areal: Double,
    val nummer: Int,
    val ankomst: LocalTime? = null) {
}