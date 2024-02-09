package Semesterprøve2018.controller

import Semesterprøve2018.model.Arrangement
import Semesterprøve2018.model.Tutor
import Semesterprøve2018.model.Uddannelse
import Semesterprøve2018.storage.Storage
import java.time.LocalDate
import java.time.LocalTime


object Controller {
    /**
     * Create a new Uddannelse.
     * Pre: -
     */
    fun createUddannelse(name: String?): Uddannelse {
        val uddannelse = Uddannelse(name!!)
        Storage.addUddannelse(uddannelse)
        return uddannelse
    }

    /**
     * Create a new Tutor.
     * Pre: -
     */
    fun createTutor(name: String?, email: String?): Tutor {
        val tutor = Tutor(name!!, email!!)
        Storage.addTutor(tutor)
        return tutor
    }

    fun createArragement(titel: String?, date: LocalDate?, startTid: LocalTime?, slutTid: LocalTime?, pris: Double?): Arrangement {
        val arrangement = Arrangement(titel!!, date!!, startTid!!, slutTid!!, pris!!)
        Storage.addArrangement(arrangement)
        return arrangement
    }

    fun addTutorToArrangement(tutor: Tutor, arrangement: Arrangement) {
        arrangement.addTutor(tutor)
    }




}