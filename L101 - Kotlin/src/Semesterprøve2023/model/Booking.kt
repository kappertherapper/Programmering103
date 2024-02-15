package Semesterprøve2023.model

import java.time.LocalDate
import java.time.LocalTime
data class Booking(
    // link 0..* --> 1 Spiller
    val spiller: Spiller,
    // link 0..* --> 1 Bane
    val bane: Bane,
    val dato: LocalDate,
    val tid: LocalTime,
    val single: Boolean

)

