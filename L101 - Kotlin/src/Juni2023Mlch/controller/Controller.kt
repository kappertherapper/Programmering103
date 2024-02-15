package controller

import model.Bane
import model.Booking
import model.Kategori
import model.Spiller
import storage.Storage
import java.io.FileNotFoundException
import java.io.PrintWriter
import java.time.LocalDate
import java.time.LocalTime

object Controller {
//    lateinit var storage: Storage

    fun opretSpiller(navn: String, uddannelse: String): Spiller {
        val spiller = Spiller(navn, uddannelse)
        Storage.addSpiller(spiller)
        return spiller
    }

    fun opretBooking(
        dato: LocalDate,
        tid: LocalTime,
        single: Boolean,
        spiller: Spiller,
        bane: Bane
    ): Booking {
        val booking = Booking(dato, tid, single, spiller, bane)
        spiller.addBooking(booking)
        bane.addBooking(booking)
        return booking
    }

    fun opretBane(
        nummer: Int,
        inde: Boolean,
        førsteTid: LocalTime,
        sidsteTid: LocalTime,
        kategori: Kategori
    ): Bane {
        val bane = Bane(nummer, inde, førsteTid, sidsteTid, kategori)
        Storage.addBane(bane)
        return bane
    }

    fun opretKategori(navn: String, prisKrSingle: Int, prisKrDouble: Int): Kategori {
        val kategori = Kategori(navn, prisKrSingle, prisKrDouble)
        Storage.addKategori(kategori)
        return kategori
    }

    // S7
    fun samletBooketDoubleTid(uddannelse: String, kategori: Kategori): Int {
        var samletTid = 0
        for (bane in Storage.alleBaner) {
            if (bane.kategori == kategori) {
                for (booking in bane.bookings) {
                    if (!booking.single && booking.spiller.uddannelse == uddannelse) {
                        samletTid++
                    }
                }
            }
        }
        return samletTid
    }

    fun samletBooketDoubleTid1(uddannelse: String, kategori: Kategori) {
        Storage.alleBaner
            .filter { bane -> bane.kategori == kategori }
            .flatMap { bane -> bane.bookings }
            .count { booking -> !booking.single && booking.spiller.uddannelse == uddannelse }
    }

    // S9
    fun findLedigBane(dato: LocalDate, tid: LocalTime, kategori: Kategori): Bane? {
        for (bane in Storage.alleBaner) {
            if (bane.kategori == kategori && bane.tidLedig(dato, tid)) {
                return bane
            }
        }
        return null
    }

    fun findLedigBane1(dato: LocalDate, tid: LocalTime, kategori: Kategori): Bane? {
        return Storage.alleBaner.firstOrNull { bane ->
            bane.kategori == kategori && bane.tidLedig(dato, tid)
        }
    }

    // S10
    fun printAlleBookings(filNavn: String) {
        try {
            PrintWriter(filNavn).use { writer ->
                for (bane in Storage.alleBaner) {
                    for (booking in bane.bookings) {
                        writer.print("Bane nr. ${bane.nummer},")
                        writer.print(" dag: ${booking.dato} kl. ${booking.tid},")
                        writer.print(if (booking.single) " spil: single," else " spil: double,")
                        writer.println(" spiller: ${booking.spiller.navn}")
                    }
                }
            }
        } catch (ex: FileNotFoundException) {
            println("FEJL: ${ex.message}")
        }
    }

    fun printAlleBookings1(fileName: String) {
        try {
            PrintWriter(fileName).use { writer ->
                Storage.alleBaner
                    .flatMap { bane -> bane.bookings }
                    .forEach { booking ->
                        with(booking) {
                            writer.print("Bane nr. ${bane.nummer},")
                            writer.print(" dag: $dato kl. $tid,")
                            writer.print(if (single) " spil: single," else " spil: double,")
                            writer.println(" spiller: ${spiller.navn}")
                        }
                    }
            }
        } catch (ex: FileNotFoundException) {
            println("FEJL: ${ex.message}")
        }
    }
}
