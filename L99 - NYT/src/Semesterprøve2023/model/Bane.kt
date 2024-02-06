package Semesterprøve2023.model

import java.time.LocalDate
import java.time.LocalTime

data class Bane(
    val nummer: Int,
    val inde: Boolean,
    val førsteTid: LocalTime,
    val sidsteTid: LocalTime,
    // link 0..* --> 1 Kategori
    val kategori: Kategori
) {

    private val _bookings: MutableList<Booking> = mutableListOf();
    val bookings: List<Booking>
        get() = _bookings

    //-------------------------------------------------------------------------------------------

    fun addBooking(booking: Booking) = _bookings.add(booking)
    fun removeBooking(booking: Booking) = _bookings.remove(booking)

    //-------------------------------------------------------------------------------------------

    // S2
    fun booketTimerPåDato(dato: LocalDate): Int {
        var count = 0
        for (booking in bookings) {
            if (dato == booking.dato)
                count++
        }
        return count
    }

    //-------------------------------------------------------------------------------------------

    fun bookedetimerPåDato(dato: LocalDate): Int =
        bookings.count { dato == it.dato }

    // S4
    fun antalBookningerPrTime(): IntArray {
        val conut = sidsteTid.hour - førsteTid.hour + 1
        val bookingCounts = IntArray(conut)
        for (booking in bookings) {
            bookingCounts[booking.tid.hour - førsteTid.hour]++
        }
        return bookingCounts
    }
}