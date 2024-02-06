package Semesterprøve2023.controller

import Semesterprøve2023.controller.Controller.createBane
import Semesterprøve2023.controller.Controller.createBooking
import Semesterprøve2023.controller.Controller.createKategori
import Semesterprøve2023.model.Bane
import Semesterprøve2023.model.Booking
import Semesterprøve2023.model.Kategori
import Semesterprøve2023.model.Spiller
import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalTime.*


class App {

    fun initStorage() {

        with(Controller) {
            //Kategori
            var luksus = createKategori(navn = "Luksus", prisKrSingle = 100, prisKrDouble = 200)
            var mellem = createKategori(navn = "Mellem", prisKrSingle = 50, prisKrDouble = 100)
            var begynder = createKategori(navn = "Begynder", prisKrSingle = 25, prisKrDouble = 50)


            //Baner
            //Indendørs
            var et =
                createBane(nummer = 1, inde = true, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = luksus)
            var to =
                createBane(nummer = 2, inde = true, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = luksus)
            var tre =
                createBane(nummer = 3, inde = true, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = mellem)


            //Udendørs
            var fire =
                createBane(nummer = 4, inde = false, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = mellem)
            var fem =
                createBane(nummer = 5, inde = false, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = begynder)
            var seks =
                createBane(nummer = 6, inde = false, førsteTid = of(9, 0), sidsteTid = of(17, 0), kategori = begynder)


            //Spillere
            var andreas = createSpiller(navn = "Andreas", uddannelse = "DMU")
            var petra = createSpiller(navn = "Petra", uddannelse = "DMU")
            var henrik = createSpiller(navn = "Henrik", uddannelse = "ITA")
            var ulla = createSpiller(navn = "Ulla", uddannelse = "ITA")


            //Bookinger
            var and = createBooking(
                spiller = andreas,
                bane = tre,
                dato = LocalDate.of(2023, 6, 20),
                tid = of(10, 0),
                single = true
            )
            var and2 = createBooking(
                spiller = andreas,
                bane = to,
                dato = LocalDate.of(2023, 6, 22),
                tid = of(10, 0),
                single = false
            )
            var hen = createBooking(
                spiller = henrik,
                bane = tre,
                dato = LocalDate.of(2023, 6, 20),
                tid = of(11, 0),
                single = false
            )
            var ull = createBooking(
                spiller = ulla,
                bane = tre,
                dato = LocalDate.of(2023, 6, 20),
                tid = of(16, 0),
                single = false
            )
            var ull2 = createBooking(
                spiller = ulla,
                bane = fem,
                dato = LocalDate.of(2023, 6, 23),
                tid = of(17, 0),
                single = true
            )
        }
    }
}