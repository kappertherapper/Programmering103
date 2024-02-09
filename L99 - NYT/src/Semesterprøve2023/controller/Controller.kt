package Semesterprøve2023.controller

import Semesterprøve2023.model.Bane
import Semesterprøve2023.model.Booking
import Semesterprøve2023.model.Kategori
import Semesterprøve2023.model.Spiller
import Semesterprøve2023.storage.Storage
import java.time.LocalDate
import java.time.LocalTime


object Controller {

    /**
     * Opretter ny Spiller
     * Pre: navn empty, Uddannelse empty
     */
    fun createSpiller(navn: String, uddannelse: String) : Spiller {
        val spiller = Spiller(navn, uddannelse)
        Storage.addSpiller(spiller)
        return spiller
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Bane
     * Pre: nummer null, inde false, førsteTid null, sidsteTid null
     */
    fun createBane(nummer: Int, inde: Boolean, førsteTid: LocalTime?, sidsteTid: LocalTime?, kategori: Kategori?): Bane {
        val bane = Bane(nummer, inde, førsteTid!!, sidsteTid!!, kategori!!)
        Storage.addBane(bane)
        return bane
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Kategori
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     */
    fun createKategori(navn: String, prisKrSingle: Int, prisKrDouble: Int): Kategori {
        val kategori = Kategori(navn, prisKrSingle, prisKrDouble)
        Storage.addKategori(kategori)
        return kategori
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Booking
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     * Tilføjer også booking til spiller og bane
     */
    fun createBooking(spiller: Spiller, bane: Bane, dato: LocalDate, tid: LocalTime, single: Boolean): Booking {
        val booking = Booking(spiller, bane, dato, tid, single)
        spiller.addBooking(booking)
        bane.addBooking(booking)
        return booking
    }

    // -------------------------------------------------------------------------

    /**
     * Returnere den samlede tid for bookinger til double spil
     * foretaget af spillere på den givne uddannelse på baner af den givne kategori
     */
    fun samletBooketDoubleTid(uddannelse: String, kategori: Kategori): Int {
        var samletTid = 0
        for (spiller in Storage.spillere) {
            for (booking in spiller.bookings) {
                if (spiller.uddannelse == uddannelse && booking.bane.kategori == kategori && !booking.single) {
                    samletTid = booking.tid.hour
                }
            }
        }
        return samletTid
    }

    // S10
    fun findLedigBane(list: ArrayList<Bane> , dato: LocalDate, tid: LocalTime, kategori: Kategori): Bane? {
        var i = 0
        while (i < list.size) {
            val k = list[i]
            if (k.tidLedig(dato, tid) && k.kategori == kategori ) return list[i] else i++
        }
        return null
    }
}