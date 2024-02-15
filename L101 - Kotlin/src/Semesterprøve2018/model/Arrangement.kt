package Semesterprøve2018.model

import java.time.LocalDate
import java.time.LocalTime

data class Arrangement (
    val titel: String,
    val date: LocalDate,
    val startTid: LocalTime,
    val slutTid: LocalTime,
    val pris: Double
    ) {

    private val _tutore: MutableList<Tutor> = mutableListOf()
    val tutore: List<Tutor>
        get() = _tutore

//-------------------------------------------------------------------------------------------

    fun addTutor(tutor: Tutor) {
        _tutore.add(tutor)
    }
}
