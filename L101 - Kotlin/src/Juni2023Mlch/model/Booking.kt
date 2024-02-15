package model

import java.time.LocalDate
import java.time.LocalTime

class Booking(
    val dato: LocalDate,
    val tid: LocalTime,
    val single: Boolean,
    // link 0..* --- 1 Spiller, komposition
    val spiller: Spiller,
    // link 0..* --- 1 Bane
    var bane: Bane
) {
    override fun toString(): String {
        val singleStr = if (single) "single" else "double"
        return "$dato kl. $tid, $singleStr, bane nr. ${bane.nummer}, $spiller"
    }
}
