package Semesterprøve2023.model

data class Spiller(
    val navn: String,
    val uddannelse: String) {

    // link 1 -> 0.* Booking (komposition)
    private val _bookings: MutableList<Booking> = mutableListOf(); // _ = private felt
    val bookings: List<Booking>
        get() = _bookings

    //-------------------------------------------------------------------------------------------

    fun addBooking(booking: Booking) = _bookings.add(booking)
    fun removeBooking(booking: Booking) = _bookings.remove(booking)

    //-------------------------------------------------------------------------------------------

    //S3
    fun samletPris(kategori: Kategori): Int {
        var pris = 0
        for (booking in bookings) {
            with(booking) {//skal stå booking foran alle bane, men denne gøre sejt
                if (kategori == bane.kategori)
                    pris += if (single) {
                        bane.kategori.prisKrSingle
                    } else {
                        bane.kategori.prisKrDouble

                    }
            }
        }
        return pris
    }
}