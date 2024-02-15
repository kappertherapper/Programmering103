package Semesterprøve2018.storage

import Semesterprøve2018.model.Arrangement
import Semesterprøve2018.model.Tutor
import Semesterprøve2018.model.Uddannelse
import Semesterprøve2023.model.Spiller

object Storage {

    private val _uddannelser: MutableList<Uddannelse> = mutableListOf() // _ = private felt
    val uddannelser: List<Uddannelse>
        get() = _uddannelser

    fun addUddannelse(uddannelse: Uddannelse) = _uddannelser.add(uddannelse)
    fun removeUddannelse(uddannelse: Uddannelse) = _uddannelser.remove(uddannelse)

    //-------------------------------------------------------------------------------------------

    private val _tutore: MutableList<Tutor> = mutableListOf()
    val tutore: List<Tutor>
        get() = _tutore

    fun addTutor(tutor: Tutor) = _tutore.add(tutor)
    fun removeTutor(tutor: Tutor) = _tutore.remove(tutor)

    //-------------------------------------------------------------------------------------------

    private val _arrangementer: MutableList<Arrangement> = mutableListOf()
    val arrangementer: List<Arrangement>
        get() = _arrangementer

    fun addArrangement(arrangement: Arrangement) = _arrangementer.add(arrangement)
    fun removeArragment(arrangement: Arrangement) = _arrangementer.remove(arrangement)

    //-------------------------------------------------------------------------------------------
}