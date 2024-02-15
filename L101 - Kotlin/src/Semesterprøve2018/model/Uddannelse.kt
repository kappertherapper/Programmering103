package Semesterprøve2018.model

class Uddannelse (
    val navn: String
) {
    private val _hold: MutableList<Hold> = mutableListOf();
    val holds: List<Hold>
        get() = _hold

    fun addHold(hold: Hold) = _hold.add(hold)

    //S9
    fun tutorOversigt(): MutableList<String> {
        val oversigt: MutableList<String> = mutableListOf()
        for (hold in _hold) if (hold.tutor != null) with(hold) {
            oversigt += (tutor?.navn) + uddannelse?.navn + betegnelse + tutor?.email + holdleder
        }
        return oversigt
    }

    companion object {
        val holds: Any
            get() {
                TODO()
            }
    }
}

