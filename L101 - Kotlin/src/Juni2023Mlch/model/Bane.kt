package model

import java.time.LocalDate
import java.time.LocalTime

class Bane(
    val nummer: Int,
    val inde: Boolean,
    val førsteTid: LocalTime,
    val sidsteTid: LocalTime,
    // link 0..* --> 1 Kategori
    var kategori: Kategori
) {
    // link 1 --- 0..* Booking
    private val _bookings: MutableList<Booking> = mutableListOf()
    val bookings: List<Booking>
        get() = _bookings

    fun addBooking(booking: Booking) = _bookings.add(booking)
    fun removeBooking(booking: Booking) = _bookings.remove(booking)

    // S2
    fun bookedeTimerPåDato(dato: LocalDate): Int {
        var timer = 0
        for (booking in bookings) {
            if (booking.dato == dato) {
                timer++
            }
        }
        return timer
    }

    fun bookedeTimerPåDato1(dato: LocalDate): Int =
        bookings.count { booking -> booking.dato == dato }

    // S4 (8 p)
    fun antalBookningerPrTime(): IntArray {
        val count = sidsteTid.hour - førsteTid.hour + 1
        val bookingsCounts = IntArray(count)
        //for (hour in førsteTid.hour..sidsteTid.hour) {
            for (booking in bookings) {
                //if (booking.tid.hour == hour) {
                    bookingsCounts[booking.tid.hour - førsteTid.hour]++
                //}
            }
        //}
        return bookingsCounts
    }

    fun antalBookningerPrTime1(): IntArray {
        return (førsteTid.hour..sidsteTid.hour)
            .map { hour -> bookings.count { booking -> booking.tid.hour == hour } }
            .toIntArray()
    }

    // S8
    fun tidLedig(dato: LocalDate, tid: LocalTime): Boolean {
        for (booking in bookings) {
            if (booking.dato == dato && booking.tid == tid) {
                return false
            }
        }
        return true
    }

    fun tidLedig1(dato: LocalDate, tid: LocalTime): Boolean {
        return bookings.none { booking ->
            booking.dato == dato && booking.tid == tid
        }
    }

    override fun toString(): String {
        val indeStr = if (inde) "inde" else "ude"
        return "Nr. $nummer $indeStr ($førsteTid->$sidsteTid), $kategori"
    }
}
