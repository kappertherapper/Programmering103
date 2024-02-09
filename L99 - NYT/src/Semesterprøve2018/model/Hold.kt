package Semesterprøve2018.model

data class Hold (
    var betegnelse: String,
    var holdleder: String,
    var uddannelse: Uddannelse,
    var tutor: Tutor
) {

    fun setTutor(tutor: Tutor, hold: Hold) = run { hold.tutor = tutor }

    // S2
    fun holdArrangementsPris(): Double {
        var sum = 0.0
        for (arrangement in tutor.arrangementer) {
            sum += arrangement.pris
        }
        return sum
    }


    // S3
    fun harTidsoverlap(arrangement: Arrangement): Boolean {
        var i = 0;
        while (i < tutor.arrangementer.size) {
            val a = tutor.arrangementer[i]
            if (a.startTid.isAfter(arrangement.startTid) || a.slutTid.isBefore(arrangement.slutTid))
                return true
            else
                i++;
        }
        return false;
    }
}