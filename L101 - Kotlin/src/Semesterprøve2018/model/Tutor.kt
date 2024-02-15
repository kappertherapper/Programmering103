package Semesterprøve2018.model

data class Tutor (
    var navn: String,
    var email: String
    ) {

    private val _hold: MutableList<Hold> = mutableListOf();
    val hold: List<Hold>
        get() = _hold

    private val _arrangementer: MutableList<Arrangement> = mutableListOf();
    val arrangementer: List<Arrangement>
        get() = _arrangementer

    //-------------------------------------------------------------------------------------------

    fun addHold(hold: Hold) {
        _hold.add(hold)
    }

    fun addArrangement(arrangement: Arrangement) {
        _arrangementer.add(arrangement)
    }

    // S1
    fun arrangementsPris(): Double {
        var sum = 0.0
        for (arrangement in arrangementer) {
            sum += arrangement.pris
        }
        return sum
    }
}