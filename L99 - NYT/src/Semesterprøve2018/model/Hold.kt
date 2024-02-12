package Semesterprøve2018.model

data class Hold(
    var betegnelse: String,
    var holdleder: String,
    var uddannelse: Uddannelse? = null,
    var tutor: Tutor? = null
) {

    private val _uddannelser: MutableList<Uddannelse> = mutableListOf();
    val uddannelser: List<Uddannelse>
        get() = _uddannelser

    //-------------------------------------------------------------------------------------------

    fun setTutor(tutor: Tutor) {
        tutor.also { this.tutor = it }
    }


    // S2
    fun holdArrangementsPris(): Double {
        var sum = 0.0
        for (arrangement in tutor?.arrangementer!!) sum += arrangement.pris
        return sum
    }


    // S3
    fun harTidsoverlap(arrangement: Arrangement): Boolean {
        var i = 0;
        while (i < tutor?.arrangementer!!.size) {
            val a = tutor?.arrangementer?.get(i)
            if (a != null) {
                with(arrangement) {
                    if (startTid.isAfter(startTid) || slutTid.isBefore(slutTid)) return true
                    else i++
                }
            }
        }
        return false;
    }
}