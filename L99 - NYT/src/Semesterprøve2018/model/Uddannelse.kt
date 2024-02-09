package Semesterprøve2018.model

import Semesterprøve2023.model.Booking

data class Uddannelse (
    val navn: String
) {
    private val _hold: MutableList<Hold> = mutableListOf();
    val holds: List<Hold>
        get() = _hold
}

