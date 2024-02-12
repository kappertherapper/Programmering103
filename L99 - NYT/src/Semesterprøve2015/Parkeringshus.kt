package Semesterprøve2015


data class Parkeringshus (val adresse: String, var saldo: Int) {

    private val _parkeringsPladser: MutableList<Parkeringsplads> = mutableListOf();
    val parkeringsPladser: List<Parkeringsplads>
        get() = _parkeringsPladser

    //S2
    fun antalLedigePladser(): Int {
        var pladser = 0
        for (parkeringsplads in _parkeringsPladser) {
            if (parkeringsplads.ankomst == null) {
                pladser++
            }
        }
        return pladser
    }

    //S3
    fun findPladsMedBil(regNr: String): Any {
        var i = 0
        while (i < parkeringsPladser.size) {
            val k = parkeringsPladser[i]
            if (k.equals(regNr))
                return parkeringsPladser[i].bil
            else i++
        }
        return -1
    }
}