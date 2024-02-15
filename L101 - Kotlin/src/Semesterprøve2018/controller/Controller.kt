package Semesterprøve2018.controller

import Semesterprøve2018.model.Arrangement
import Semesterprøve2018.model.Hold
import Semesterprøve2018.model.Tutor
import Semesterprøve2018.model.Uddannelse
import Semesterprøve2018.storage.Storage
import java.time.LocalDate
import java.time.LocalTime


object Controller {
    /**
     * Create a new Uddannelse.
     */
    fun createUddannelse(name: String?): Uddannelse {
        val uddannelse = Uddannelse(name!!)
        Storage.addUddannelse(uddannelse)
        return uddannelse
    }



    //-------------------------------------------------------------------------------------------

    /**
     * Create a new Tutor.
     */
    fun createTutor(name: String?, email: String?): Tutor {
        val tutor = Tutor(name!!, email!!)
        Storage.addTutor(tutor)
        return tutor
    }

    //-------------------------------------------------------------------------------------------

    /**
     * Create a new Arrangement.
     */
    fun createArragement(titel: String?, date: LocalDate?, startTid: LocalTime?, slutTid: LocalTime?, pris: Double?): Arrangement {
        val arrangement = Arrangement(titel!!, date!!, startTid!!, slutTid!!, pris!!)
        Storage.addArrangement(arrangement)
        return arrangement
    }

    fun addTutorToArrangement(tutor: Tutor, arrangement: Arrangement) {
        try {
            arrangement.addTutor(tutor)
        } catch (_: RuntimeException) {
        }
    }

    //-------------------------------------------------------------------------------------------

    /**
     * Create a new Hold.
     */
    fun createHold(betegnelse: String?, holdleder: String): Hold {
        val hold = Hold(betegnelse!!, holdleder)
        return hold
    }

    fun addTutorToHold(tutor: Tutor, hold: Hold) {
        hold.setTutor(tutor)
    }

    //-------------------------------------------------------------------------------------------

    fun holdUdenTutor(): MutableList<Hold> {
        val udannelse = Uddannelse("")
        val holdUdenTutor: MutableList<Hold> = mutableListOf()
        for (hold in udannelse.holds) if (hold.tutor == null) {
            holdUdenTutor.add(hold)
        }
        return holdUdenTutor
    }
}
