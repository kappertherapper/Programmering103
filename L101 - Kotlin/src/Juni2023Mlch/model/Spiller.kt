package model

class Spiller(val navn: String, val uddannelse: String) {
    // link 1 --- 0.* Booking, komposition
    private val _bookings: MutableList<Booking> = mutableListOf()
    val bookings: List<Booking>
        get() = _bookings

    fun addBooking(booking: Booking) = _bookings.add(booking)
    fun removeBooking(booking: Booking) = _bookings.remove(booking)
    // removeBooking is only used, when the booking is deleted from the application

    // S3
    fun samletPris(kategori: Kategori): Int {
        var samletPris = 0
        for (booking in bookings) {
            if (booking.bane.kategori == kategori) {
                samletPris += if (booking.single) booking.bane.kategori.prisKrSingle else
                    booking.bane.kategori.prisKrSingle
            }
        }
        return samletPris
    }

    fun samletPris1(kategori: Kategori): Int {
        return bookings
            .filter { booking -> booking.bane.kategori == kategori }
            .sumOf { booking ->
                if (booking.single) booking.bane.kategori.prisKrSingle
                else booking.bane.kategori.prisKrDouble
            }
    }

    override fun toString(): String {
        return "$navn ($uddannelse)"
    }
}
